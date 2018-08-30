package com.dhc.android.testdemoforwzw;

import android.os.Bundle;
import android.widget.TextView;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;

import butterknife.BindView;

public class TestDemoForJavaAty extends BaseActivity {


    @BindView(R.id.text1)
    TextView text1;
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
        return R.layout.aty_test_demo_for_java;
    }
}
