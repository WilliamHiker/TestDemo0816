package com.dhc.android.testdemoforwzw;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.Button;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class AnimTestAty3 extends BaseActivity {

    @BindView(R.id.button1)
    Button mButton1;

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
        return R.layout.aty3_anim_test;
    }

    @OnClick(R.id.button1)
    public void onViewClicked() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mButton1, "translationX", 300);
        animator.setDuration(300);
        animator.start();
    }
}
