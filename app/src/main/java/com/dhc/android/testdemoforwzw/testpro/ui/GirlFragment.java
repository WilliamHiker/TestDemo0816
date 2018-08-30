package com.dhc.android.testdemoforwzw.testpro.ui;

import android.os.Bundle;

import com.dhc.android.testdemoforwzw.R;
import com.dhc.android.base.base.BaseFragment;

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
