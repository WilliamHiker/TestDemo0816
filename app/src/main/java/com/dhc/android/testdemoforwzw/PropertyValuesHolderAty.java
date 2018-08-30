package com.dhc.android.testdemoforwzw;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;

import butterknife.BindView;

public class PropertyValuesHolderAty extends BaseActivity {

    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("translationX", 300f);
                PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
                PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
                ObjectAnimator.ofPropertyValuesHolder(btn, propertyValuesHolder, propertyValuesHolder1, propertyValuesHolder2).setDuration(1000).start();
            }
        });


//        ValueAnimator animator = ValueAnimator.ofFloat(0,100);
//        animator.setTarget(view);
//        animator.setDuration(1000).start();
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Float value = (Float) animation.getAnimatedValue();
//                // TODO: use the value
//            }
//        });

//        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"alpha",0.5f);
//        animator.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationCancel(Animator animation) {
//                super.onAnimationCancel(animation);
//            }
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//            }
//            @Override
//            public void onAnimationStart(Animator animation) {
//                super.onAnimationStart(animation);
//            }
//            @Override
//            public void onAnimationPause(Animator animation) {
//                super.onAnimationPause(animation);
//            }
//        });

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    public void scaleX(View view){
        Animator anim = AnimatorInflater.loadAnimator(this,R.animator.anim_2);
        anim.setTarget(view);
        anim.start();


        view.animate().alpha(0).y(300).setDuration(300).withStartAction(new Runnable() {
            @Override
            public void run() {

            }
        }).withEndAction(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });


    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.aty_property_values_holder;
    }

    private static class WrapperView {
        private View mTarget;

        public WrapperView(View target) {
            mTarget = target;
        }

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }
}
