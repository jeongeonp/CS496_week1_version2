package com.example.q.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }
    public Context getContext()
    {
        return mContext;
    }

    // Create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // If it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        // Create glide request manager
        RequestManager requestManager = Glide.with(mContext);
        // Create request builder and load image.
        RequestBuilder requestBuilder = requestManager.load(mThumbIds[position]);
        requestBuilder = requestBuilder.apply(new RequestOptions().override(250, 250));
        // Show image into target imageview.
        requestBuilder.into(imageView);
        return imageView;
    }

    // references to our images
    private String urls = "https://static.boredpanda.com/blog/wp-content/uploads/2018/04/5acb63d83493f__700-png.jpg\n" +
            "https://www.catster.com/wp-content/uploads/2018/07/Savannah-cat-long-body-shot.jpg\n" +
            "https://www.bluecross.org.uk/sites/default/files/assets/images/124044lpr.jpg\n" +
            "https://media.mnn.com/assets/images/2018/07/cat_eating_fancy_ice_cream.jpg.838x0_q80.jpg\n" +
            "https://cdn-images-1.medium.com/max/1600/1*mONNI1lG9VuiqovpnYqicA.jpeg\n" +
            "https://r.hswstatic.com/w_907/gif/tesla-cat.jpg\n" +
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg\n" +
            "https://www.readersdigest.ca/wp-content/uploads/sites/14/2011/01/4-ways-cheer-up-depressed-cat.jpg\n" +
            "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg\n" +
            "https://www.rd.com/wp-content/uploads/2016/04/01-cat-wants-to-tell-you-laptop.jpg\n" +
            "https://pbs.twimg.com/profile_images/378800000532546226/dbe5f0727b69487016ffd67a6689e75a_400x400.jpeg\n" +
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cat-quotes-1543599392.jpg\n" +
            "https://www.usmagazine.com/wp-content/uploads/2018/06/Smoothie-the-Cat-Instagram-zoom.jpg\n" +
            "https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?cs=srgb&dl=animal-cat-cute-45201.jpg&fm=jpg\n" +
            "https://amp.businessinsider.com/images/5654150584307663008b4ed8-750-563.jpg\n" +
            "https://i.ytimg.com/vi/lrvqjdMcjjQ/hqdefault.jpg\n" +
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Gatto_europeo4.jpg/250px-Gatto_europeo4.jpg\n" +
            "https://timedotcom.files.wordpress.com/2014/12/ap1109280145869.jpg\n" +
            "https://i.ytimg.com/vi/YCaGYUIfdy4/maxresdefault.jpg\n" +
            "https://timedotcom.files.wordpress.com/2018/08/new-zealand-cat-ban.jpg\n" +
            "https://s.hswstatic.com/gif/whiskers-sam.jpg\n" +
            "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?cs=srgb&dl=animal-animal-photography-cat-104827.jpg&fm=jpg\n" +
            "https://www.argospetinsurance.co.uk/assets/uploads/2017/10/pexels-photo-416160.jpeg\n" +
            "https://www.dw.com/image/42519102_303.jpg\n" +
            "https://images.pexels.com/photos/326875/pexels-photo-326875.jpeg?cs=srgb&dl=adorable-animal-blur-326875.jpg&fm=jpg\n" +
            "https://img-aws.ehowcdn.com/600x600p/photos.demandstudios.com/getty/article/165/76/87490163.jpg\n" +
            "https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/08/30/11/cat-bird.jpg\n" +
            "https://www.humanesociety.org/sites/default/files/2018/06/cat-217679.jpg\n" +
            "https://i.ytimg.com/vi/6Yt3mMBmm3M/maxresdefault.jpg\n" +
            "https://www.purina.co.uk/sites/g/files/mcldtz776/files/2017-11/How-old-is-my-cat-in-human-years_0.jpg\n" +
            "https://thewirecutter.com/wp-content/uploads/2018/07/catadoption-lowres-06052-2x1-1.jpg\n" +
            "https://amp.thisisinsider.com/images/5b840a0d3cccd123008b458c-750-562.jpg\n" +
            "https://i.amz.mshcdn.com/cQ4-JZvF7gUQHPLMlN8o-D279cM=/fit-in/1200x9600/https%3A%2F%2Fblueprint-api-production.s3.amazonaws.com%2Fuploads%2Fcard%2Fimage%2F784547%2F0c47ef8e-b577-4e31-97ab-f604315e050c.jpg\n" +
            "https://upload.wikimedia.org/wikipedia/commons/6/69/June_odd-eyed-cat_cropped.jpg\n" +
            "https://d17fnq9dkz9hgj.cloudfront.net/uploads/2012/11/152964589-welcome-home-new-cat-632x475.jpg\n" +
            "https://www.economist.com/sites/default/files/20171216_BKP511_0.jpg\n" +
            "https://www.edch.org.uk/sites/default/files/content-blocks/catsnew.jpg\n" +
            "https://www.telegraph.co.uk/content/dam/news/2017/09/08/TELEMMGLPICT000138582248-xlarge_trans_NvBQzQNjv4BqLODrYCEVrDwzaY_adYCJ4iVEeSQZANxeMT4D58rU5LA.jpeg\n" +
            "https://www.rspcansw.org.au/wp-content/uploads/2017/08/72_a-feature_cats-and-kittens_mobile.jpg\n" +
            "https://thumbs.mic.com/OTg5ZmJiYmM1YyMvaE8xVS0tenRsM2pYYUtQaU5xekZoZEticUtRPS83eDEyNjozNTAweDIzMjkvODAweDQ1MC9maWx0ZXJzOmZvcm1hdChqcGVnKTpxdWFsaXR5KDgwKS9odHRwczovL3MzLmFtYXpvbmF3cy5jb20vcG9saWN5bWljLWltYWdlcy9hMTI1YWUwNDAyMDc2YzZjZmNmOGE5ODczZmVmMzZjMDAzOTAxNWMzZTc4NzBmY2M0N2Q3OGM3YmJkMDVjNmM5LmpwZw.jpg\n" +
            "https://i.kinja-img.com/gawker-media/image/upload/s--Q4WTuzbO--/c_fill,f_auto,fl_progressive,g_north,h_264,q_80,w_470/lltozqbgqulk1rjoctzu.jpg\n" +
            "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201601/cat---facebook-and-storysize_647_011416045855.jpg\n" +
            "https://catscornervet.com/wp-content/uploads/2016/04/kitty-1.png\n" +
            "https://thewirecutter.com/wp-content/uploads/2018/04/catbeds-2x1-05936.jpg\n" +
            "https://i.ytimg.com/vi/5dsGWM5XGdg/hqdefault.jpg\n" +
            "https://atlantahumane.org/wp-content/uploads/2012/08/adopt-a-cat-1200x630.png\n" +
            "https://image.nj.com/home/njo-media/width620/img/entertainment_impact/photo/lil-bub-catsbury-park-cat-convention-asbury-park-2018jpg-42ba0699ef9f22e0.jpg\n" +
            "https://i.kym-cdn.com/entries/icons/original/000/026/638/cat.jpg\n" +
            "https://wi-images.condecdn.net/image/26lrrvzLjpx/crop/405/f/gettyimages-161785570.jpg\n" +
            "https://ichef.bbci.co.uk/news/660/cpsprodpb/FDD6/production/_100728946_catrelax.jpg\n" +
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/White_Persian_Cat.jpg/220px-White_Persian_Cat.jpg\n" +
            "https://theorphanpet.com/wp-content/uploads/2016/06/13233136_788779574558512_3397930498291044113_n.jpg\n" +
            "https://cdn5.img.sputniknews.com/images/105967/95/1059679556.jpg\n" +
            "https://peopledotcom.files.wordpress.com/2018/10/cat1.jpg\n" +
            "https://thewirecutter.com/wp-content/uploads/2018/06/cataccessories-lowres-2x1-05916.jpg\n" +
            "https://media.socastsrm.com/wordpress/wp-content/blogs.dir/348/files/2018/08/12920541_1345368955489850_5587934409579916708_n-2-960x410-1.jpg\n" +
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/kitten-playing-with-toy-mouse-royalty-free-image-590055188-1542816918.jpg\n" +
            "https://cat-bounce.com/catbounce.png\n" +
            "https://www.petmd.com/sites/default/files/petmd-cat-happy-13.jpg\n" +
            "https://media.mnn.com/assets/images/2018/07/cat_one_eye_open.jpg.838x0_q80.jpg\n" +
            "https://www.newsobserver.com/latest-news/xm78bk/picture209017294/alternates/FREE_1140/29597333_10155404324631186_359612486424514144_n.jpg\n";
    private String[] mThumbIds = urls.split("\n");
}