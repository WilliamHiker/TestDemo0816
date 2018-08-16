package com.toocms.www.testdemoforwzw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class CalenderTestTextView extends TextView {

    public boolean isSel = false;
    Paint mPaint = new Paint();
    public boolean isThisMonth;

    public CalenderTestTextView(Context context) {
        this(context, null, 0);
    }

    public CalenderTestTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalenderTestTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#FF7A00"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSel & isThisMonth){
            canvas.save();
            canvas.translate(getWidth() / 2, getHeight() / 2);
            canvas.drawCircle(0, 0, getWidth() / 2, mPaint);
            canvas.restore();
        }
    }
}
