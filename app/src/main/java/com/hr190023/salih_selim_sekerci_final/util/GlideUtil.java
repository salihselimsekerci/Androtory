package com.hr190023.salih_selim_sekerci_final.Util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class GlideUtil {
    public static void showImageFromUrl(Context context, String url, ImageView img) {
        //urlden resmi indir ve ilgili imageviewa ayarla
        Glide.with(context)
                .load(url)
                .into(img);
    }

    public static void setAsBackgroundFromBaseUrl(Context context, String filename, final ViewGroup viewGroup) {
        Glide.with(context)
                .load(Constants.BASE_URL + "images/" + filename) //ana urlye gelen dosya adını ekleyip resimi indiriyoruz
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        viewGroup.setBackground(resource); //arka plan olarak ayarla
                    }
                });
    }

}
