package com.lib.image.glide;

import android.graphics.Bitmap;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.lib.image.extend.BitmapCallback;

public class RealBitmapCallback extends com.bumptech.glide.request.target.SimpleTarget<Bitmap> {

    private BitmapCallback bitmapCallback;

    public RealBitmapCallback(BitmapCallback bitmapCallback) {
        this.bitmapCallback = bitmapCallback;
    }

    public RealBitmapCallback(int width, int height, BitmapCallback BitmapCallback) {
        super(width, height);
        this.bitmapCallback = BitmapCallback;
    }

    @Override
    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
        if (bitmapCallback != null) {
            bitmapCallback.onResourceReady(resource);
        }
    }
}
