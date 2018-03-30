package com.lib.image.annotation;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({ImageCacheStrategy.NONE, ImageCacheStrategy.SOURCE, ImageCacheStrategy.RESULT, ImageCacheStrategy.ALL})
@Retention(RetentionPolicy.SOURCE)
public @interface ImageCacheStrategy {
    int NONE = 1;
    int SOURCE = 2;
    int RESULT = 3;
    int ALL = 4;
}
