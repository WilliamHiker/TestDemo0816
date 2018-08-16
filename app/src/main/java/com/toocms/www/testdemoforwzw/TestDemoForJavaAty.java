package com.toocms.www.testdemoforwzw;

import android.os.Bundle;
import android.widget.TextView;

import com.toocms.www.testframeforwzw.base.BaseActivity;

import butterknife.BindView;

public class TestDemoForJavaAty extends BaseActivity {


    @BindView(R.id.text1)
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }























    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.aty_test_demo_for_java;
    }
}
