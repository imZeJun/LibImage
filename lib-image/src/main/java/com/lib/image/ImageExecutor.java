package com.lib.image;


import android.content.Context;
import android.widget.ImageView;

import com.lib.image.annotation.ImageWorkerType;
import com.lib.image.callback.ResourceCallback;
import com.lib.image.worker.GlideImageWorkerImpl;
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
        Holder.INSTANCE.worker = createWorker(param.getWorkerType());
    }

    private ImageWorker createWorker(@ImageWorkerType int workerType) {
        ImageWorker newWorker;
        switch (workerType) {
            case ImageWorkerType.GLIDE:
                newWorker = new GlideImageWorkerImpl(this);
                break;
            default:
                newWorker = new GlideImageWorkerImpl(this);
        }
        return newWorker;
    }

    public ImageWorkerParam getParam() {
        return param;
    }

    public Context getContext() {
        return context;
    }

    public ImageWorker getImageWorker() {
        if (Holder.INSTANCE.worker == null) {
            throw new IllegalStateException("must call buildWorker");
        }
        return Holder.INSTANCE.worker;
    }

    @Override
    public void loadImage(Context context, String url, int placeHolder, int error, ImageView imageView) {
        getImageWorker().loadImage(context, url, placeHolder, error, imageView);
    }

    @Override
    public void loadImage(Context context, String url, int placeHolder, int error, int width, int height, ResourceCallback target) {
        getImageWorker().loadImage(context, url, placeHolder, error, width, height, target);
    }

    @Override
    public void loadImage(ImageRequest request) {
        getImageWorker().loadImage(request);
    }
}
