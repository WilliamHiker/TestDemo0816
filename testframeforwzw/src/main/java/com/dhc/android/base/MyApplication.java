package com.dhc.android.base;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.dhc.android.base.manager.AppManager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public abstract class MyApplication extends Application {

    private static volatile MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppManager.instance = this;
        initOkGo();
    }

    public static MyApplication getInstance() {
        return instance;
    }


    //初始化OkGo
    private void initOkGo() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/json");
        HttpParams params = new HttpParams();
        // TODO: 2018/6/28 可以加一些头信息
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor("网络信息");
        //log打印级别，决定了log显示的详细程度
        interceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log颜色级别，决定了log在控制台显示的颜色
        interceptor.setColorLevel(java.util.logging.Level.INFO);
        builder.addInterceptor(interceptor);
        //全局的读取超时时间
        builder.readTimeout(60000L, TimeUnit.MILLISECONDS);
        //全局的写入超时时间
        builder.writeTimeout(60000L, TimeUnit.MILLISECONDS);
        //全局的连接超时时间
        builder.connectTimeout(60000L, TimeUnit.MILLISECONDS);
        //使用数据库保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(this)));
        OkGo.getInstance().init(this).setOkHttpClient(builder.build()).setCacheMode(CacheMode.NO_CACHE).setCacheTime(-1L).setRetryCount(3).addCommonHeaders(headers).addCommonParams(params);
    }
}
