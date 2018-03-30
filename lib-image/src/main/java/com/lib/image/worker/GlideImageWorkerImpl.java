package com.lib.image.worker;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lib.image.ImageExecutor;
import com.lib.image.ImageRequest;
import com.lib.image.callback.ResourceCallback;
import com.lib.image.glide.GlideResourceCallback;

public class GlideImageWorkerImpl implements ImageWorker {

    private ImageExecutor executor;

    public GlideImageWorkerImpl(ImageExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void loadImage(Context context, String url, int placeHolder, int error, ImageView imageView) {
        ImageRequest request = new ImageRequest.Builder()
                .context(context)
                .placeHolder(placeHolder)
                .error(error)
                .url(url)
                .imageView(imageView)
                .build();
        doRealRequest(request);
    }

    @Override
    public void loadImage(Context context, String url, int placeHolder, int error, int width, int height, ResourceCallback target) {
        ImageRequest request = new ImageRequest.Builder()
                .context(context)
                .placeHolder(placeHolder)
                .error(error)
                .url(url)
                .resourceCallback(width, height, target)
                .build();
        doRealRequest(request);
    }

    @Override
    public void loadImage(ImageRequest request) {
        doRealRequest(request);
    }

    private void doRealRequest(ImageRequest request) {
        //1.构造 RequestManager。
        Context context = request.getContext() != null ? request.getContext() : executor.getContext();
        if (context == null) {
            return;
        }
        RequestManager manager = Glide.with(context);
        //2.构造 DrawableRequestBuilder。
        DrawableRequestBuilder requestBuilder;
        //2.1 从网络加载或者从文件加载。
        if (!TextUtils.isEmpty(request.getUrl())) {
            requestBuilder = manager.load(request.getUrl());
        } else if (request.getFile() != null) {
            requestBuilder = manager.load(request.getFile());
        } else {
            return;
        }
        //2.2 动画
        if (request.getAnimator() != null) {
            requestBuilder = requestBuilder.animate(request.getAnimator());
        }
        //2.3 加载前占位符
        if (request.getPlaceHolder() > 0) {
            requestBuilder = requestBuilder.placeholder(request.getPlaceHolder());
        }
        //2.4 加载错误后的图片。
        if (request.getError() > 0) {
            requestBuilder = requestBuilder.error(request.getError());
        }
        //2.5 缓存策略。
        DiskCacheStrategy cacheCacheStrategy = request.getCacheStrategy() != null  ? request.getCacheStrategy() : executor.getParam().getCacheStrategy();
        if (cacheCacheStrategy != null) {
            requestBuilder = requestBuilder.diskCacheStrategy(cacheCacheStrategy);
        }
        //2.6 变换
        if (request.getBitmapTransformation() != null) {
            requestBuilder = requestBuilder.bitmapTransform(request.getBitmapTransformation());
        }
        //3.发起请求。
        if (request.getImageView() != null) {
            requestBuilder.into(request.getImageView());
        } else if (request.getResourceCallback() != null) {
            if (request.getHeight() > 0 && request.getWidth() > 0) {
                requestBuilder.into(new GlideResourceCallback(request.getWidth(), request.getHeight(), request.getResourceCallback()));
            } else {
                requestBuilder.into(new GlideResourceCallback(request.getResourceCallback()));
            }
        }

    }
}
