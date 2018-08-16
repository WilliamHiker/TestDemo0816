package com.toocms.www.testframeforwzw.api;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;
import com.toocms.www.testframeforwzw.app.ConfigType;
import com.toocms.www.testframeforwzw.app.Configurator;
import com.toocms.www.testframeforwzw.kit.ToolKit;
import com.toocms.www.testframeforwzw.manager.AppManager;

public class ApiTool<T> {
    public void getApi(String url, HttpParams params, ApiListener<T> apiListener) {
        OkGo.<T>get(ToolKit.isUrl(url) ? url : Configurator.getInstance().getCnfiguration(ConfigType.API_HOST) + url).tag(AppManager.instance).params(params).execute(apiListener);
    }

    public void postApi(String url, HttpParams params, ApiListener<T> apiListener) {
        OkGo.<T>post(ToolKit.isUrl(url) ? url : Configurator.getInstance().getCnfiguration(ConfigType.API_HOST) + url).tag(AppManager.instance).params(params).execute(apiListener);
    }

    public void downloadApi(String url, HttpParams params, FileCallback fileCallback) {
        ((GetRequest) OkGo.<T>get(ToolKit.isUrl(url) ? url : Configurator.getInstance().getCnfiguration(ConfigType.API_HOST) + url).tag(AppManager.instance).params(params)).execute(fileCallback);
    }

    public void upLoadApi(String url, HttpParams params, StringCallback stringCallback) {
        ((PostRequest) OkGo.<T>post(ToolKit.isUrl(url) ? url : Configurator.getInstance().getCnfiguration(ConfigType.API_HOST) + url).tag(AppManager.instance).params(params)).execute(stringCallback);
    }
}
