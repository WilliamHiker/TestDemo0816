package com.toocms.www.testdemoforwzw.testpro.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.toocms.www.testdemoforwzw.R;
import com.toocms.www.testframeforwzw.base.BaseActivity;
import com.toocms.www.testframeforwzw.base.BaseFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    List<Fragment> fragmentList = new ArrayList<>();
    String[] titles = {"首页","干活","妹子"};

    BaseFragmentAdapter adapter;

    @Override
    public void initData(Bundle bundle) {
        setSupportActionBar(toolbar);

        //可以通过传递一个Bitmap对象给Palette，并调用它的Palette.generate()静态方法
        // 或者Palette.generate.Async()方法来创建一个Palette。
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_round);
        //创建Palette对象
//        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(Palette palette) {
//                //通过Palette来获取对应的色调
//                Palette.Swatch vibrant = palette.getVibrantSwatch();
//                //将颜色设置给相应的组件
//                toolbar.setBackgroundDrawable(new ColorDrawable(vibrant.getRgb()));
//                Window window = getWindow();
//                window.setStatusBarColor(vibrant.getRgb());
//            }
//        });

        fragmentList.clear();
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(GanhuoFragment.newInstance());
        fragmentList.add(GirlFragment.newInstance());

        if (adapter == null) {
            adapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragmentList, titles);
        }
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
    }
}
