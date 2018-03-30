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
import com.lib.image.annotation.ImageCacheStrategy;
import com.lib.image.extend.BitmapCallback;
import com.lib.image.glide.RealBitmapCallback;
import com.lib.image.glide.RealImageAnimator;

public class GlideImageWorker implements ImageWorker {

    private ImageExecutor executor;

    public GlideImageWorker(ImageExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void loadImage(Context context, String url, int placeHolder, int error, @ImageCacheStrategy int cacheStrategy, ImageView imageView) {
        ImageRequest request = new ImageRequest.Builder()
                .context(context)
                .placeHolder(placeHolder)
                .error(error)
                .cacheStrategy(cacheStrategy)
                .url(url)
                .imageView(imageView)
                .build();
        doRealRequest(request);
    }

    @Override
    public void loadImage(Context context, String url, int placeHolder, int error, @ImageCacheStrategy int cacheStrategy, int width, int height, BitmapCallback target) {
        ImageRequest request = new ImageRequest.Builder()
                .context(context)
                .placeHolder(placeHolder)
                .error(error)
                .cacheStrategy(cacheStrategy)
                .url(url)
                .bitmapCallback(width, height, target)
                .build();
        doRealRequest(request);
    }

    @Override
    public void loadImage(ImageRequest request) {
        doRealRequest(request);
    }

    private void doRealRequest(ImageRequest request) {
        //1.构造 RequestManager。
        Context context = request.getContext();
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
        if (request.getImageAnimator() != null) {
            requestBuilder = requestBuilder.animate(new RealImageAnimator(request.getImageAnimator()));
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
        int cacheCacheStrategy = request.getCacheStrategy();
        if (cacheCacheStrategy <= 0) {
            cacheCacheStrategy = executor.getParam().getCacheStrategy();
        }
        if (cacheCacheStrategy > 0) {
            switch (request.getCacheStrategy()) {
                case ImageCacheStrategy.ALL:
                    requestBuilder = requestBuilder.diskCacheStrategy(DiskCacheStrategy.ALL);
                    break;
                case ImageCacheStrategy.NONE:
                    requestBuilder = requestBuilder.diskCacheStrategy(DiskCacheStrategy.NONE);
                    break;
                case ImageCacheStrategy.SOURCE:
                    requestBuilder = requestBuilder.diskCacheStrategy(DiskCacheStrategy.SOURCE);
                    break;
                case ImageCacheStrategy.RESULT:
                    requestBuilder = requestBuilder.diskCacheStrategy(DiskCacheStrategy.RESULT);
                    break;
                default:
                    break;
            }
        }
        //3.发起请求。
        if (request.getImageView() != null) {
            requestBuilder.into(request.getImageView());
        } else if (request.getBitmapCallback() != null) {
            if (request.getBitmapCallbackHeight() > 0 && request.getBitmapCallbackWidth() > 0) {
                requestBuilder.into(new RealBitmapCallback(request.getBitmapCallbackWidth(), request.getBitmapCallbackHeight(), request.getBitmapCallback()));
            } else {
                requestBuilder.into(new RealBitmapCallback(request.getBitmapCallback()));
            }
        }

    }
}
