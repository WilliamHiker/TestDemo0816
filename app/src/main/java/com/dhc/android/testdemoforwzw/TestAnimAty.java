package com.dhc.android.testdemoforwzw;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class TestAnimAty extends BaseActivity {


    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;

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
        return R.layout.aty_test_anim;
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Animation animator = AnimationUtils.loadAnimation(this, R.anim.anim_1);
                mButton1.startAnimation(animator);
                break;
            case R.id.button2:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
                alphaAnimation.setDuration(300);
                mButton2.startAnimation(alphaAnimation);
                break;
        }
    }
}
