package com.dhc.android.testdemoforwzw;

import android.os.Bundle;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;

public class OverrideViewAty extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.aty_override_view;
    }
}
