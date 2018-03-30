package com.lib.image;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

public class ImageGlideModule implements GlideModule {

    private static final int DEFAULT_CACHE_DIR_SIZE = 1024 * 1024 * 30;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        ImageWorkerParam param = ImageExecutor.getInstance().getParam();
        if (param != null) {
            MemorySizeCalculator calculator = new MemorySizeCalculator(context);
            int memoryCacheSize = param.getMemoryCacheSize();
            if (memoryCacheSize <= 0) {
                memoryCacheSize = calculator.getMemoryCacheSize();
            }
            builder.setMemoryCache(new LruResourceCache(memoryCacheSize));
            int diskCacheSize = param.getDiskCacheSize();
            if (diskCacheSize <= 0) {
                diskCacheSize = DEFAULT_CACHE_DIR_SIZE;
            }
            if (param.isExternalCache()) {
                builder.setDiskCache(new InternalCacheDiskCacheFactory(context, context.getPackageName(), diskCacheSize));
            } else {
                builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, context.getPackageName(), diskCacheSize));
            }
        }
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
