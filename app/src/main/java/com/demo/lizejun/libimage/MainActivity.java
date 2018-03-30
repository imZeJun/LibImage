package com.demo.lizejun.libimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lib.image.ImageExecutor;
import com.lib.image.ImageRequest;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv_content);
        startCustomRequest();
    }

    private void startRequest() {
        ImageExecutor.getInstance().loadImage(
                this,
                "http://i.imgur.com/DvpvklR.png",
                0,
                0,
                mImageView);
    }

    private void startCustomRequest() {
        ImageRequest request = new ImageRequest.Builder()
                .context(this)
                .url("http://i.imgur.com/DvpvklR.png")
                .cacheStrategy(DiskCacheStrategy.SOURCE)
                .imageView(mImageView)
                .build();
        ImageExecutor.getInstance().loadImage(request);
    }
}
