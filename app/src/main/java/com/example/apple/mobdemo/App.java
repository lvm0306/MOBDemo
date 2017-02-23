package com.example.apple.mobdemo;

import android.app.Application;

import cn.sharesdk.framework.ShareSDK;
import cn.smssdk.SMSSDK;

/**
 * Created by apple on 17/2/22.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SMSSDK.initSDK(this, "1b88e0cf1c2fb", "7e7cc9cbdd8ee52c482a27587e2a890b");
        ShareSDK.initSDK(this);
    }
}
