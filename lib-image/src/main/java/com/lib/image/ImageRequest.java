package com.lib.image;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.lib.image.callback.ResourceCallback;

import java.io.File;

public class ImageRequest {

    private String url;
    private Context context;
    private ImageView imageView;
    private File file;
    private ResourceCallback resourceCallback;
    private int height;
    private int width;
    private ViewPropertyAnimation.Animator animator;
    private int placeHolder;
    private int error;
    private BitmapTransformation bitmapTransformation;
    private DiskCacheStrategy cacheStrategy;

    public ImageRequest(Builder builder) {
        this.url = builder.url;
        this.context = builder.context;
        this.imageView = builder.imageView;
        this.file = builder.file;
        this.resourceCallback = builder.resourceCallback;
        this.width = builder.width;
        this.height = builder.height;
        this.animator = builder.animator;
        this.placeHolder = builder.placeHolder;
        this.error = builder.error;
        this.cacheStrategy = builder.cacheStrategy;
        this.bitmapTransformation = builder.bitmapTransformation;
    }

    public String getUrl() {
        return url;
    }

    public Context getContext() {
        return context;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public File getFile() {
        return file;
    }

    public ResourceCallback getResourceCallback() {
        return resourceCallback;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ViewPropertyAnimation.Animator getAnimator() {
        return animator;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public int getError() {
        return error;
    }

    public DiskCacheStrategy getCacheStrategy() {
        return cacheStrategy;
    }

    public BitmapTransformation getBitmapTransformation() {
        return bitmapTransformation;
    }

    public static final class Builder {

        private String url;
        private Context context;
        private ImageView imageView;
        private File file;
        private ResourceCallback resourceCallback;
        private int width;
        private int height;
        private int error;
        private int placeHolder;
        private DiskCacheStrategy cacheStrategy;
        private ViewPropertyAnimation.Animator animator;
        private BitmapTransformation bitmapTransformation;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder imageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public Builder file(File file) {
            this.file = file;
            return this;
        }

        public Builder resourceCallback(int width, int height, ResourceCallback resourceCallback) {
            this.width = width;
            this.height = height;
            this.resourceCallback = resourceCallback;
            return this;
        }

        public Builder resourceCallback(ResourceCallback resourceCallback) {
            this.resourceCallback = resourceCallback;
            return this;
        }

        public Builder animator(ViewPropertyAnimation.Animator animator) {
            this.animator = animator;
            return this;
        }

        public Builder placeHolder(int placeHolder) {
            this.placeHolder = placeHolder;
            return this;
        }

        public Builder error(int error) {
            this.error = error;
            return this;
        }

        public Builder cacheStrategy(DiskCacheStrategy cacheStrategy) {
            this.cacheStrategy = cacheStrategy;
            return this;
        }

        public Builder bitmapTransformation(BitmapTransformation bitmapTransformation) {
            this.bitmapTransformation = bitmapTransformation;
            return this;
        }

        public ImageRequest build() {
            return new ImageRequest(this);
        }

    }
}
