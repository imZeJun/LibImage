package com.demo.lizejun.libimage;

import android.app.Application;

import com.lib.image.ImageExecutor;
import com.lib.image.ImageWorkerParam;
import com.lib.image.annotation.ImageWorkerType;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageWorkerParam param = new ImageWorkerParam.Builder()
                .workerType(ImageWorkerType.GLIDE)
                .build();
        ImageExecutor.getInstance().buildWorker(this, param);
    }
}
