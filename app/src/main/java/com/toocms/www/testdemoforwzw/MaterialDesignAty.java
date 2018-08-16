package com.toocms.www.testdemoforwzw;

import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.toocms.www.testframeforwzw.base.BaseActivity;

import butterknife.BindView;

public class MaterialDesignAty extends BaseActivity {

    @BindView(R.id.tv1)
    TextView mTv1;
    @BindView(R.id.tv2)
    TextView mTv2;
    @BindView(R.id.tv3)
    TextView mTv3;
    @BindView(R.id.tv_rect)
    TextView mTvRect;
    @BindView(R.id.tv_circle)
    TextView mTvCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //动态改变视图高度
        mTv1.animate().translationZ(100).setDuration(3000);

        //获取Outline
        ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //修改outline为特定形状
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 30);
            }
        };

        //获取Outline
        ViewOutlineProvider viewOutlineProvider2 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        };

        //重新设置形状
        mTvRect.setOutlineProvider(viewOutlineProvider1);
        mTvCircle.setOutlineProvider(viewOutlineProvider2);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.aty_material_design;
    }
}
