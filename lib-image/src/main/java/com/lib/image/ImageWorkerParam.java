package com.lib.image;


import com.lib.image.annotation.ImageCacheStrategy;
import com.lib.image.annotation.ImageWorkerType;

public class ImageWorkerParam {

    private int memoryCacheSize;
    private int diskCacheSize;
    private boolean externalCache;
    private @ImageCacheStrategy int cacheStrategy;
    private @ImageWorkerType int workerType;

    public ImageWorkerParam(Builder builder) {
        this.memoryCacheSize = builder.memoryCacheSize;
        this.diskCacheSize = builder.diskCacheSize;
        this.workerType = builder.workerType;
        this.externalCache = builder.externalCache;
        this.cacheStrategy = builder.cacheStrategy;
    }

    public @ImageWorkerType int getWorkerType() {
        return workerType;
    }

    public int getMemoryCacheSize() {
        return memoryCacheSize;
    }

    public int getDiskCacheSize() {
        return diskCacheSize;
    }

    public boolean isExternalCache() {
        return externalCache;
    }

    public @ImageCacheStrategy int getCacheStrategy() {
        return cacheStrategy;
    }

    public static final class Builder {

        private int diskCacheSize;
        private int memoryCacheSize;
        private boolean externalCache;
        private @ImageWorkerType
        int workerType;
        private @ImageCacheStrategy
        int cacheStrategy;

        public Builder memoryCacheSize(int memoryCacheSize) {
            this.memoryCacheSize = memoryCacheSize;
            return this;
        }

        public Builder workerType(@ImageWorkerType int workerType) {
            this.workerType = workerType;
            return this;
        }

        public Builder diskCacheSize(int diskCacheSize) {
            this.diskCacheSize = diskCacheSize;
            return this;
        }

        public Builder externalCache(boolean externalCache) {
            this.externalCache = externalCache;
            return this;
        }

        public Builder cacheStrategy(@ImageCacheStrategy int cacheStrategy) {
            this.cacheStrategy = cacheStrategy;
            return this;
        }

        public ImageWorkerParam build() {
            return new ImageWorkerParam(this);
        }

    }
}
