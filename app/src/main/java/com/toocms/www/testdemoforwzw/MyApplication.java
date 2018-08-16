package com.toocms.www.testdemoforwzw;

import com.toocms.www.testframeforwzw.app.MyApp;

public class MyApplication extends com.toocms.www.testframeforwzw.MyApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MyApp.init(this).withApiHost("http://api.funxiaojun.com/index.php/").configure();
    }
}
