package com.dhc.android.testdemoforwzw;

import com.dhc.android.base.app.MyApp;

public class MyApplication extends com.dhc.android.base.MyApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MyApp.init(this).withApiHost("http://api.funxiaojun.com/index.php/").configure();
    }
}
