package com.lib.image.worker;


import android.content.Context;
import android.widget.ImageView;

import com.lib.image.ImageRequest;
import com.lib.image.annotation.ImageCacheStrategy;
import com.lib.image.extend.BitmapCallback;

/**
 *
 * 图片加载接口声明。
 *
 * @author lizejun
 */
public interface ImageWorker {

    /**
     * 加载图片到 ImageView 中显示。
     *
     * @param context 上下文，传入 Activity 可以根据生命周期管理请求。
     * @param url 网络地址。
     * @param placeHolder 图片下载前的占位符。
     * @param error 图片加载错误后的图片。
     * @param cacheStrategy 缓存策略。
     * @param imageView 显示的 ImageView。
     */
    void loadImage(Context context, String url, int placeHolder, int error, @ImageCacheStrategy int cacheStrategy, ImageView imageView);

    /**
     * 加载图片，通过回调的方式返回 Bitmap。
     *
     * @param context 上下文，传入 Activity 可以根据生命周期管理请求。
     * @param url 网络地址。
     * @param placeHolder 图片下载前的占位符。
     * @param error 图片加载错误后的图片。
     * @param cacheStrategy 缓存策略。
     * @param width 下载 Bitmap 的宽度。
     * @param height 下载 Bitmap 的高度。
     * @param target 回调接口。
     */
    void loadImage(Context context, String url, int placeHolder, int error, @ImageCacheStrategy int cacheStrategy, int width, int height, BitmapCallback target);

    /**
     * 加载，自定义请求参数。
     *
     * @param request 自定义请求体。
     */
    void loadImage(ImageRequest request);

}
