package com.dhc.android.base.view.banner;

import android.content.Context;
import android.graphics.Color;

import com.dhc.android.base.R;
import com.zhy.autolayout.utils.AutoUtils;

public class NumberIndicator extends android.support.v7.widget.AppCompatTextView {

    public NumberIndicator(Context context) {
        super(context);
        setTextColor(Color.WHITE);
        setTextSize(14);
        setBackgroundResource(R.drawable.text_indicator_bg);
        int padding = AutoUtils.getPercentWidthSize(5);
        setPadding(padding, padding, padding, padding);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //保证TextIndicator的宽高一致(正方形)
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
