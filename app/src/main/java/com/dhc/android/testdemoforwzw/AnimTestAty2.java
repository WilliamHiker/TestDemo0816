package com.dhc.android.testdemoforwzw;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class AnimTestAty2 extends BaseActivity {

    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;
    @BindView(R.id.button5)
    Button mButton5;
    @BindView(R.id.button6)
    Button mButton6;
    @BindView(R.id.button7)
    Button mButton7;

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
        return R.layout.aty2_anim_test;
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                AlphaAnimation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);
                mButton1.setAnimation(animation);
                mButton1.startAnimation(animation);
                break;
            case R.id.button2:
                RotateAnimation animation1 = new RotateAnimation(0, 360, 100, 100);
                animation1.setDuration(1000);
                mButton2.setAnimation(animation1);
                mButton2.startAnimation(animation1);
                break;
            case R.id.button3:
                RotateAnimation animation2 = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5F, RotateAnimation.RELATIVE_TO_SELF, 0.5F);
                animation2.setDuration(1000);
                mButton3.setAnimation(animation2);
                mButton3.startAnimation(animation2);
                break;
            case R.id.button4:
                TranslateAnimation animation3 = new TranslateAnimation(0, 200, 0, 300);
                animation3.setDuration(1000);
                mButton4.setAnimation(animation3);
                mButton4.startAnimation(animation3);
                break;
            case R.id.button5:
                ScaleAnimation animation4 = new ScaleAnimation(0, 2, 0, 2);
                animation4.setDuration(1000);
                mButton5.setAnimation(animation4);
                mButton5.startAnimation(animation4);
                break;
            case R.id.button6:
                ScaleAnimation animation5 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
                animation5.setDuration(1000);
                mButton6.setAnimation(animation5);
                mButton6.startAnimation(animation5);
                break;
            case R.id.button7:
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(1000);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
                alphaAnimation.setDuration(1000);
                animationSet.addAnimation(alphaAnimation);
                TranslateAnimation translateAnimation = new TranslateAnimation(0,100,0,200);
                translateAnimation.setDuration(1000);
                animationSet.addAnimation(translateAnimation);
                mButton7.startAnimation(animationSet);
                break;
        }
    }
}
