package com.dhc.android.base.api;

import android.content.Context;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;
import com.dhc.android.base.app.ConfigType;
import com.dhc.android.base.app.Configurator;
import com.dhc.android.base.kit.ToolKit;

public class ApiTool<T> {
    public void getApi(Context context,String url, HttpParams params, ApiListener<T> apiListener) {
        OkGo.<T>get(ToolKit.isUrl(url) ? url : Configurator.getInstance().getCnfiguration(ConfigType.API_HOST) + url).tag(context).params(params).execute(apiListener);
    }

    public void postApi(Context context,String url, HttpParams params, ApiListener<T> apiListener) {
        OkGo.<T>post(ToolKit.isUrl(url) ? url : Configurator.getInstance().getCnfiguration(ConfigType.API_HOST) + url).tag(context).params(params).execute(apiListener);
    }

    public void downloadApi(Context context,String url, HttpParams params, FileCallback fileCallback) {
        ((GetRequest) OkGo.<T>get(ToolKit.isUrl(url) ? url : Configurator.getInstance().getCnfiguration(ConfigType.API_HOST) + url).tag(context).params(params)).execute(fileCallback);
    }

    public void upLoadApi(Context context,String url, HttpParams params, StringCallback stringCallback) {
        ((PostRequest) OkGo.<T>post(ToolKit.isUrl(url) ? url : Configurator.getInstance().getCnfiguration(ConfigType.API_HOST) + url).tag(context).params(params)).execute(stringCallback);
    }
}
