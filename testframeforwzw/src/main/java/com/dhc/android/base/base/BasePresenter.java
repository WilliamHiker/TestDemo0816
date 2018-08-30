package com.dhc.android.base.base;

import android.os.Bundle;

public abstract class BasePresenter<T extends IBaseView> {

    protected T mView;

    /**
     * 绑定View
     */
    public void onAttch(T view) {
        this.mView = view;
    }

    /**
     * 做初始化的操作，需要在view的试图初始化完成之后才能调用
     */
    public abstract void onCreate();

    /**
     * 默认在view销毁的时候调用，解除绑定
     * 在view销毁前释放presenter中的对象资源
     */
    public void onDestroy() {
        mView = null;
    }

    /**
     * 容易被回收掉时保存数据
     * @param outState
     */
    public abstract void onSaveInstanceState(Bundle outState);
}
