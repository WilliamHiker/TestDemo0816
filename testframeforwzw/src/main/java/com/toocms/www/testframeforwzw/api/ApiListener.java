package com.toocms.www.testframeforwzw.api;

import com.google.gson.Gson;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.ParameterizedType;

import okhttp3.Call;

public abstract class ApiListener<T> extends AbsCallback<T> {

    @Override
    public void onSuccess(Response<T> response) {
        this.onComplete(response.body(), response.getRawCall(), response.getRawResponse());
    }

    @Override
    public void onError(Response<T> response) {
        super.onError(response);
    }

    public T convertResponse(okhttp3.Response response) throws Throwable {
        if (response.isSuccessful()) {
            //获取泛型T实际对应的Class对象
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> aClass = (Class<T>) type.getActualTypeArguments()[0];

            String json = response.body().string();
            response.close();
            return new Gson().fromJson(json, aClass);
        } else {
            throw new IllegalStateException("无法解析的类型");
        }
    }

    public abstract void onComplete(T bean, Call call, okhttp3.Response response);

    public void onError(String error, Call call, okhttp3.Response response) {
    }
}
