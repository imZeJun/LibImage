package com.demo.lizejun.libimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.lib.image.ImageExecutor;
import com.lib.image.ImageRequest;
import com.lib.image.annotation.ImageCacheStrategy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView view = (ImageView) findViewById(R.id.iv_content);
        ImageExecutor.getInstance().loadImage(
                this,
                "http://i.imgur.com/DvpvklR.png",
                0,
                0,
                ImageCacheStrategy.SOURCE,
                view);
    }
}
