package com.lib.image.glide;

import android.view.View;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.lib.image.extend.ImageAnimator;

public class RealImageAnimator implements ViewPropertyAnimation.Animator {

    private ImageAnimator imageAnimator;

    public RealImageAnimator(ImageAnimator imageAnimator) {
        this.imageAnimator = imageAnimator;
    }

    @Override
    public void animate(View view) {
        if (imageAnimator != null) {
            imageAnimator.animate(view);
        }
    }
}
