//package com.toocms.www.testdemoforwzw;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.RectF;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.util.TypedValue;
//import android.view.View;
//
//public class CustomProgressBar extends View {
//
//    private int mFirstColor;        //第一圈的颜色
//    private int mSecondColor;       //第二圈的颜色
//    private int mCircleWidth;       //圈的宽度
//    private Paint mPaint;       //画笔
//    private int mProgress;      //当前进度
//    private int mSpeed;     //速度
//    private boolean isNext = false;     //是否应该开始下一个
//
//    public CustomProgressBar(Context context) {
//        this(context, null, 0);
//    }
//
//    public CustomProgressBar(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public CustomProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyleAttr, 0);
//        int n = a.getIndexCount();
//        for (int i = 0; i < n; i++) {
//            int attr = a.getIndex(i);
//            switch (attr) {
//                case R.styleable.CustomProgressBar_firstColor:
//                    mFirstColor = a.getColor(attr, Color.GREEN);
//                    break;
//                case R.styleable.CustomProgressBar_secondColor:
//                    mSecondColor = a.getColor(attr, Color.RED);
//                    break;
//                case R.styleable.CustomProgressBar_circleWidth:
//                    mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
//                    break;
//                case R.styleable.CustomProgressBar_speed:
//                    mSpeed = a.getInt(attr, 20);
//                    break;
//            }
//        }
//        a.recycle();
//        mPaint = new Paint();
//        new Thread() {
//            @Override
//            public void run() {
//                while (true) {
//                    mProgress++;
//                    if (mProgress == 360) {
//                        mProgress = 0;
//                        if (!isNext) isNext = true;
//                        else isNext = false;
//                    }
//                    postInvalidate();
//                    try {
//                        Thread.sleep(mSpeed);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        int centre = getWidth()/2;
//        int radius = centre - mCircleWidth/2;
//        mPaint.setStrokeWidth(mCircleWidth);
//        mPaint.setAntiAlias(true);
//        mPaint.setStyle(Paint.Style.STROKE);
//        RectF oval = new RectF(centre - radius,centre-radius,centre+radius,centre+radius);
//        if (!isNext){
//            mPaint.setColor(mFirstColor);
//            canvas.drawCircle(centre,centre,radius,mPaint);
//            mPaint.setColor(mSecondColor);
//            canvas.drawArc(oval,-90,mProgress,false,mPaint);
//        }else {
//            mPaint.setColor(mSecondColor);
//            canvas.drawCircle(centre,centre,radius,mPaint);
//            mPaint.setColor(mFirstColor);
//            canvas.drawArc(oval,-90,mProgress,false,mPaint);
//        }
//    }
//}
