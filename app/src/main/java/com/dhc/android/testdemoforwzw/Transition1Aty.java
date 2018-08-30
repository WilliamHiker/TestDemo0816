package com.dhc.android.testdemoforwzw;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;

public class Transition1Aty extends BaseActivity {

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
        return R.layout.aty_transition1;
    }

    private Intent mIntent;

    //设置不同动画效果
    public void explode(View view) {
        mIntent = new Intent(this, Transition2Aty.class);
        mIntent.putExtra("flag", 0);
        startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    //设置不同动画效果
    public void slide(View view) {
        mIntent = new Intent(this, Transition2Aty.class);
        mIntent.putExtra("flag", 1);
        startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    //设置不同动画效果
    public void fade(View view) {
        mIntent = new Intent(this, Transition2Aty.class);
        mIntent.putExtra("flag", 2);
        startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    //设置不同动画效果
    public void share(View view) {
        View fab = findViewById(R.id.fab_button);
        mIntent = new Intent(this, Transition2Aty.class);
        mIntent.putExtra("flag", 3);

        //创建共享元素
        startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this,
                //创建多个共享元素
                Pair.create(view, "share"), Pair.create(fab, "fab")).toBundle());
    }
}
