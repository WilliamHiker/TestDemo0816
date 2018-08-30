package com.dhc.android.base.base.lazyFgt;

import android.os.Bundle;

import com.dhc.android.base.base.UICallback;
import com.dhc.android.base.base.UiDelegate;
import com.dhc.android.base.base.UiDelegateBase;
import com.dhc.android.base.kit.KnifeKit;

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
