//package com.toocms.www.testdemoforwzw;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.util.TypedValue;
//import android.view.MotionEvent;
//import android.view.View;
//
//public class CustomVolumControlBar extends View {
//
//    private int mFirstColor;    //第一圈颜色
//    private int mSecondColor;   //第二圈颜色
//    private int mCircleWidth;       //圈的宽度
//    private Paint mPaint;       //画笔
//    private int mCurrentCount = 3;      //当前进度
//    private Bitmap mImge;       //中间的图片
//    private int mSplitSize;     //每个块块间的间隙
//    private int mCount;     //个数
//    private Rect mRect;
//    private int xDown;
//    private int xUp;
//
//    public CustomVolumControlBar(Context context) {
//        this(context, null, 0);
//    }
//
//    public CustomVolumControlBar(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public CustomVolumControlBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomVolumControlBar, defStyleAttr, 0);
//        int n = a.getIndexCount();
//        for (int i = 0; i < n; i++) {
//            int attr = a.getIndex(i);
//            switch (attr) {
//                case R.styleable.CustomVolumControlBar_firstColor:
//                    mFirstColor = a.getColor(attr, Color.GREEN);
//                    break;
//                case R.styleable.CustomVolumControlBar_secondColor:
//                    mSecondColor = a.getColor(attr, Color.CYAN);
//                    break;
//                case R.styleable.CustomVolumControlBar_bg:
//                    mImge = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
//                    break;
//                case R.styleable.CustomVolumControlBar_circleWidth:
//                    mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
//                    break;
//                case R.styleable.CustomVolumControlBar_dotCount:
//                    mCount = a.getInt(attr, 20);
//                    break;
//                case R.styleable.CustomVolumControlBar_splitSize:
//                    mSplitSize = a.getInt(attr, 20);
//                    break;
//            }
//        }
//        a.recycle();
//        mPaint = new Paint();
//        mRect = new Rect();
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        mPaint.setAntiAlias(true);
//        mPaint.setStrokeWidth(mCircleWidth);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        mPaint.setStyle(Paint.Style.STROKE);
//        int centre = getWidth() / 2;
//        int radius = centre - mCircleWidth / 2;
//        drawOval(canvas, centre, radius);
//        int relRadius = radius - mCircleWidth / 2;
//        mRect.left = (int) (relRadius - Math.sqrt(2) * 1.0f / 2 * relRadius) + mCircleWidth;
//        mRect.top = (int) (relRadius - Math.sqrt(2) * 1.0f / 2 * relRadius) + mCircleWidth;
//        mRect.bottom = (int) (mRect.left + Math.sqrt(2) * relRadius);
//        mRect.right = (int) (mRect.left + Math.sqrt(2) * relRadius);
//        if (mImge.getWidth() < Math.sqrt(2) * relRadius) {
//            mRect.left = (int) (mRect.left + Math.sqrt(2) * relRadius * 1.0f / 2 - mImge.getWidth() * 1.0f / 2);
//            mRect.top = (int) (mRect.top + Math.sqrt(2) * relRadius * 1.0f / 2 - mImge.getHeight() * 1.0f / 2);
//            mRect.right = (int) (mRect.left + mImge.getWidth());
//            mRect.bottom = (int) (mRect.top + mImge.getHeight());
//        }
//        canvas.drawBitmap(mImge, null, mRect, mPaint);
//    }
//
//    private void drawOval(Canvas canvas, int centre, int radius) {
//        float itemSize = (360 * 1.0f - mCount * mSplitSize) / mCount;
//        RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius);
//        mPaint.setColor(mFirstColor);
//        for (int i = 0; i < mCount; i++) {
//            canvas.drawArc(oval, i * (itemSize + mSplitSize), itemSize, false, mPaint);
//        }
//        mPaint.setColor(mSecondColor);
//        for (int i = 0; i < mCurrentCount; i++) {
//            canvas.drawArc(oval, i * (itemSize + mSplitSize), itemSize, false, mPaint);
//        }
//    }
//
//    public void up() {
//        mCurrentCount++;
//        postInvalidate();
//    }
//
//    public void down() {
//        mCurrentCount--;
//        postInvalidate();
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.e("***", event.getAction()+"...");
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                xDown = (int) event.getY();
//                break;
//            case MotionEvent.ACTION_UP:
//                xUp = (int) event.getY();
//                if (xUp > xDown) {
//                    down();
//                } else {
//                    up();
//                }
//                Log.e("***", xDown + "///" + xUp);
//                break;
//        }
//        return true;
//    }
//}
