package com.lib.image;


import android.content.Context;
import android.widget.ImageView;

import com.lib.image.annotation.ImageCacheStrategy;
import com.lib.image.annotation.ImageWorkerType;
import com.lib.image.extend.BitmapCallback;
import com.lib.image.worker.GlideImageWorker;
import com.lib.image.worker.ImageWorker;

public class ImageExecutor implements ImageWorker {

    private ImageWorkerParam param;
    private Context context;
    private ImageWorker worker;

    private static final class Holder {
        public static final ImageExecutor INSTANCE = new ImageExecutor();
    }

    public static ImageExecutor getInstance() {
        return Holder.INSTANCE;
    }

    public void buildWorker(Context context, ImageWorkerParam param) {
        this.context = context.getApplicationContext();
        this.param = param;
        ImageWorker worker;
        switch (param.getWorkerType()) {
            case ImageWorkerType.GLIDE:
                worker = new GlideImageWorker(this);
                break;
            default:
                worker = new GlideImageWorker(this);
        }
        Holder.INSTANCE.worker = worker;
    }

    public ImageWorkerParam getParam() {
        return param;
    }

    public ImageWorker getImageWorker() {
        if (Holder.INSTANCE.worker == null) {
            throw new IllegalStateException("must call buildWorker");
        }
        return Holder.INSTANCE.worker;
    }

    @Override
    public void loadImage(Context context, String url, int placeHolder, int error, @ImageCacheStrategy int cacheStrategy, ImageView imageView) {
        getImageWorker().loadImage(context, url, placeHolder, error, cacheStrategy, imageView);
    }

    @Override
    public void loadImage(Context context, String url, int placeHolder, int error, @ImageCacheStrategy int cacheStrategy, int width, int height, BitmapCallback target) {
        getImageWorker().loadImage(context, url, placeHolder, error, cacheStrategy, width, height, target);
    }

    @Override
    public void loadImage(ImageRequest request) {
        getImageWorker().loadImage(request);
    }
}
