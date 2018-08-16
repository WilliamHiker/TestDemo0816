package com.toocms.www.testdemoforwzw.testpro.ui;

import android.os.Bundle;

import com.toocms.www.testdemoforwzw.R;
import com.toocms.www.testframeforwzw.base.BaseFragment;

public class GirlFragment extends BaseFragment {


    @Override
    public void initData(Bundle savedInstanceState) {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fgt_btn2;
    }

    public static GirlFragment newInstance() {
        return new GirlFragment();
    }
}
