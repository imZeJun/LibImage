package com.lib.image.glide;

import android.graphics.Bitmap;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.lib.image.callback.ResourceCallback;

public class GlideResourceCallback extends com.bumptech.glide.request.target.SimpleTarget<Bitmap> {

    private ResourceCallback resourceCallback;

    public GlideResourceCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

    public GlideResourceCallback(int width, int height, ResourceCallback ResourceCallback) {
        super(width, height);
        this.resourceCallback = ResourceCallback;
    }

    @Override
    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
        if (resourceCallback != null) {
            resourceCallback.onResourceReady(resource);
        }
    }
}
