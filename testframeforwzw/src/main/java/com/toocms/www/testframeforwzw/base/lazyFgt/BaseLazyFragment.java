package com.toocms.www.testframeforwzw.base.lazyFgt;

import android.os.Bundle;

import com.toocms.www.testframeforwzw.base.UICallback;
import com.toocms.www.testframeforwzw.base.UiDelegate;
import com.toocms.www.testframeforwzw.base.UiDelegateBase;
import com.toocms.www.testframeforwzw.kit.KnifeKit;

import butterknife.Unbinder;

public abstract class BaseLazyFragment extends RootLazyFragment implements UICallback {
    private UiDelegate uiDelegate;
    private Unbinder unbinder;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            unbinder = KnifeKit.bind(this, getRealRootView());
        }
        setListener();
        initData(savedInstanceState);
    }

    @Override
    protected void onDestoryLazy() {
        super.onDestoryLazy();
        getUiDelegate().destory();
    }

    @Override
    public void setListener() {

    }

    protected UiDelegate getUiDelegate() {
        if (uiDelegate == null) {
            uiDelegate = UiDelegateBase.create(getContext());
        }
        return uiDelegate;
    }
}
