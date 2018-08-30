package com.dhc.android.testdemoforwzw.testpro.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.dhc.android.testdemoforwzw.R;
import com.dhc.android.testdemoforwzw.TopBar;
import com.dhc.android.base.base.BaseFragment;

import butterknife.BindView;

public class GanhuoFragment extends BaseFragment {

    @BindView(R.id.topBar)
    TopBar topBar;

    @Override
    public void initData(Bundle savedInstanceState) {
        topBar.setButtonVisable(1,true);
        topBar.setOnTopbarClickLisenter(new TopBar.topbarClickLisenter() {
            @Override
            public void leftClick() {
                Toast.makeText(context, "hahah", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(context, "hahah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fgt_btn2;
    }

    public static GanhuoFragment newInstance() {
        return new GanhuoFragment();
    }
}
