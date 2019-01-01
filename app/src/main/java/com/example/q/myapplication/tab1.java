package com.example.q.myapplication;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class tab1 extends AppCompatActivity {
    public final int CONTACT_LOAD_BUTTON = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firsttab);
        loadOrRequestPermission();

        /*setContentView(R.layout.list_item);
        Bundle b = getIntent().getExtras();
        TextView notes = (TextView) findViewById(R.id.info);
        if (b != null) {
            notes.setText(b.getCharSequence("notes"));
        }
        else {
            notes.setText("why null");
        }*/


    }

    public void launchMoreInfo(View view) {
        Intent intent = new Intent(this, tab1_moreinfo.class);
        startActivity(intent);
    }
    public void loadOrRequestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            doLoad();
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, CONTACT_LOAD_BUTTON);
        }
    }

    public void doLoad()
    {
        Toast.makeText(this, "loading...", Toast.LENGTH_SHORT).show();
        new LoadContactTask().execute();
    }

    public void onLoadButtonClick(View view)
    {
        loadOrRequestPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch(requestCode)
        {
            case CONTACT_LOAD_BUTTON:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    doLoad();
                }
        }
    }

    private class LoadContactTask extends AsyncTask<Void,Void,LinkedList<Tuple<String, String>>> {

        @Override
        protected LinkedList<Tuple<String, String>> doInBackground(Void... voids) {
            LinkedList<Tuple<String, String>> retval = new LinkedList<>();
            ContentResolver cr = getContentResolver();
            Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                    null, null, null, null);

            if ((cur != null ? cur.getCount() : 0) > 0) {
                while (cur != null && cur.moveToNext()) {
                    String id = cur.getString(
                            cur.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cur.getString(cur.getColumnIndex(
                            ContactsContract.Contacts.DISPLAY_NAME));
                    if (cur.getInt(cur.getColumnIndex(
                            ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                        Cursor pCur = cr.query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                                new String[]{id}, null);
                        while (pCur.moveToNext()) {
                            String phoneNo = pCur.getString(pCur.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER));
                            retval.add(new Tuple<>(name, phoneNo));
                        }
                        pCur.close();
                    }
                }
            }
            if (cur != null) {
                cur.close();
            }
            return retval;
        }

        @Override
        protected void onPostExecute(LinkedList<Tuple<String, String>> result)
        {
            ListView simpleList = (ListView) findViewById(R.id.list);
            MyAdapter arrayAdapter = new MyAdapter(tab1.this, R.layout.list_item, result);
            simpleList.setAdapter(arrayAdapter);
        }
    }
}
class Tuple<X, Y> {
    final X first;
    final Y second;
    Tuple(X x, Y y)
    {
        first = x;
        second = y;
    }

}
class MyAdapter extends BaseAdapter
{
    private LayoutInflater inflater;
    private LinkedList<Tuple<String, String>> data;
    private int layout;

    public MyAdapter(Context ctx, int layout_init, LinkedList<Tuple<String, String>> data_init) {
        if(data_init == null)
        {
            data = new LinkedList<>();
        }
        else
        {
            data = data_init;
        }
        layout = layout_init;
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = inflater.inflate(layout, viewGroup, false);
        }

        Tuple<String, String> d = data.get(i);

        TextView name = (TextView)view.findViewById(R.id.name);
        name.setText(d.first);
        TextView contact = (TextView)view.findViewById(R.id.mobile);
        contact.setText(d.second);
        /*TextView notes = (TextView)view.findViewById(R.id.notes);
        notes.setText("why null");*/

        return view;
    }

}
