package com.lib.image.annotation;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({ImageWorkerType.GLIDE})
@Retention(RetentionPolicy.SOURCE)
public @interface ImageWorkerType {
    int GLIDE = 1;
}
