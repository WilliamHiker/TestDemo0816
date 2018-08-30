package com.dhc.android.testdemoforwzw;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

public class OverrideView extends ViewGroup {

    private int mScreenHeight;
    private Scroller mScroller;
    private int mLastY;
    private int mStart;
    private int mEnd;


    public OverrideView(Context context) {
        this(context, null, 0);
    }

    public OverrideView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OverrideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        mWindowManager.getDefaultDisplay().getMetrics(mDisplayMetrics);
        mScreenHeight = mDisplayMetrics.heightPixels;
        mScroller = new Scroller(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        //设置ViewGroup的高度
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * childCount;
        setLayoutParams(mlp);
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                child.layout(1, i * mScreenHeight, r, (i + 1) * mScreenHeight);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            //遍历查找所有的子View
            View childView = getChildAt(i);
            //测量所有子View的宽高
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获得最左上角的坐标相对于View刚显示出来原点的位置
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:   //按下
                //记录本次左上角的坐标，为下次动作做准备
                mLastY = y;
                //获取初始化的y轴坐标
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:   //滑动
                Log.e("***","ACTION_DOWN:"+y+"///"+mLastY+"///"+mStart);
                //判断是否完成动作
                if (!mScroller.isFinished()) {
                    //如果没有动作的话就立刻停止动画
                    mScroller.abortAnimation();
                }
                //当前手指位置坐标减去没有动作时的坐标
                int dy = mLastY - y;    //滑动距离dy
                //如果检测到位置坐标小于0，说明当前坐标是处于第一页，用户视图向下滑动
                if (getScrollY() < 0) {
                    //直接将滑动距离置为0
                    dy = 0;
                }
                //如果超过了父View的宽高减去子View的高度的话（处于最后一页），并且用户试图向上滑动
                if (getScrollY() > getHeight() - mScreenHeight) {
                    //直接将滑动距离置为0
                    dy = 0;
                }
                //辅助滑动，执行滑动
                scrollBy(0, dy);
                //记录左上角坐标，为下次动作做准备
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:     //松手
                //获取结束点坐标
                mEnd = getScrollY();
                //获取滑动距离
                int dScrollY = mEnd - mStart;
                //判断执行滑动的方向（等于零可以防止双击滑动）
                if (dScrollY >= 0) {
                    //不符合就回到初始位置
                    if (dScrollY < mScreenHeight / 3) {
                        mScroller.startScroll(0, getScrollY(),
                                0, -dScrollY);
                    } else {
                        //符合就向下滑动一整页
                        //向下辅助滑动的距离需要将子View的高度减去用户已经滑动过的距离
                        mScroller.startScroll(0, getScrollY(),
                                0, mScreenHeight - dScrollY);
                    }
                } else {
                    //如果滑动的距离小于0，即手指向上滑动（-dScrollY相当于滑动距离，以为dScrollY小于0）
                    if (-dScrollY < mScreenHeight / 3) {
                        //滑动距离，计算要注意滑动距离为负数
                        mScroller.startScroll(0, getScrollY(),
                                0, -dScrollY);
                    } else {
                        mScroller.startScroll(0, getScrollY(),
                                0, -mScreenHeight - dScrollY);
                    }
                }
                break;
        }
        //刷新界面
        postInvalidate();
        return true;
    }
}
