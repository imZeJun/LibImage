package com.lib.image;


import android.content.Context;
import android.widget.ImageView;

import com.lib.image.annotation.ImageCacheStrategy;
import com.lib.image.extend.BitmapCallback;
import com.lib.image.extend.ImageAnimator;

import java.io.File;

public class ImageRequest {

    private String url;
    private Context context;
    private ImageView imageView;
    private File file;
    private BitmapCallback bitmapCallback;
    private int bitmapCallbackHeight;
    private int bitmapCallbackWidth;
    private ImageAnimator imageAnimator;
    private int placeHolder;
    private int error;
    private @ImageCacheStrategy int cacheStrategy;

    public ImageRequest(Builder builder) {
        this.url = builder.url;
        this.context = builder.context;
        this.imageView = builder.imageView;
        this.file = builder.file;
        this.bitmapCallback = builder.bitmapCallback;
        this.bitmapCallbackWidth = builder.bitmapCallbackWidth;
        this.bitmapCallbackHeight = builder.bitmapCallbackHeight;
        this.imageAnimator = builder.imageAnimator;
        this.placeHolder = builder.placeHolder;
        this.error = builder.error;
        this.cacheStrategy = builder.cacheStrategy;
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

    public BitmapCallback getBitmapCallback() {
        return bitmapCallback;
    }

    public int getBitmapCallbackWidth() {
        return bitmapCallbackWidth;
    }

    public int getBitmapCallbackHeight() {
        return bitmapCallbackHeight;
    }

    public ImageAnimator getImageAnimator() {
        return imageAnimator;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public int getError() {
        return error;
    }

    public @ImageCacheStrategy
    int getCacheStrategy() {
        return cacheStrategy;
    }

    public static final class Builder {

        private String url;
        private Context context;
        private ImageView imageView;
        private File file;
        private BitmapCallback bitmapCallback;
        private int bitmapCallbackWidth;
        private int bitmapCallbackHeight;
        private ImageAnimator imageAnimator;
        private int error;
        private int placeHolder;
        private @ImageCacheStrategy int cacheStrategy;

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

        public Builder bitmapCallback(int width, int height, BitmapCallback bitmapCallback) {
            this.bitmapCallbackWidth = width;
            this.bitmapCallbackHeight = height;
            this.bitmapCallback = bitmapCallback;
            return this;
        }

        public Builder bitmapCallback(BitmapCallback bitmapCallback) {
            this.bitmapCallback = bitmapCallback;
            return this;
        }

        public Builder animator(ImageAnimator imageAnimator) {
            this.imageAnimator = imageAnimator;
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

        public Builder cacheStrategy(@ImageCacheStrategy int cacheStrategy) {
            this.cacheStrategy = cacheStrategy;
            return this;
        }

        public ImageRequest build() {
            return new ImageRequest(this);
        }

    }
}
