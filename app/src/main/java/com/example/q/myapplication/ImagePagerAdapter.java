package com.example.q.myapplication;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoViewAttacher;

import java.util.List;

//import android.support.v7.app.ActionBarActivity;

public class ImagePagerAdapter extends PagerAdapter {

    private List<ImageView> images;
    PhotoViewAttacher mAttacher;
    public ImagePagerAdapter(List<ImageView> images) {
        this.images = images;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // imageView == imgDisplay
        //  == viewLayout
//diskCacheStrategy(DiskCacheStrategy.ALL).
        ImageView imageView = images.get(position);
        // imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        mAttacher = new PhotoViewAttacher(imageView);
        // container.addView(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
}
