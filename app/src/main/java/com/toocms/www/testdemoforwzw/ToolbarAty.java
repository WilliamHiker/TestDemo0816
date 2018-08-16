package com.toocms.www.testdemoforwzw;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.toocms.www.testframeforwzw.base.BaseActivity;

import butterknife.BindView;

public class ToolbarAty extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbar.setLogo(R.drawable.ic_launcher);
        mToolbar.setTitle("主标题");
        mToolbar.setSubtitle("副标题");
        setSupportActionBar(mToolbar);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public int getLayoutId() {
        return R.layout.aty_toolbar;
    }
}
