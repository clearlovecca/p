package com.example.myapplication.utlis;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class GlideUtils {

    @BindingAdapter("android:url")
    public static void setImage(ImageView iv,String url){
        Glide.with(iv).load(url).transform(new CenterCrop(),new RoundedCorners(20)).into(iv);
    }
}
