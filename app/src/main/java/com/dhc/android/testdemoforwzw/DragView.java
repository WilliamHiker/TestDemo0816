package com.dhc.android.testdemoforwzw;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

public class DragView extends View {

    private int mLastX;
    private int mLastY;
    private Scroller mScroller;

    public DragView(Context context) {
        this(context, null, 0);
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){       //判断是否完成了整个滑动。true：动画尚未完成
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();   //实时获取View的位置变化，实时更新滑动
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();     //实时测量点击位置到自己左边的距离
        int y = (int) event.getY();     //实时测量点击位置到自己顶边的距离
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;     //存下开始时候的位置
                mLastY = y;      //存下开始时候的位置
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;       //x轴偏移量
                int offsetY = y - mLastY;       //y轴偏移量
//                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);        //方法1：重写layout()方法
//                offsetLeftAndRight(offsetX);      //方法2：直接移动左右和上下的偏移量
//                offsetTopAndBottom(offsetY);
//                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();     //方法3：通过改变左外边距和上外边距的参数，改变位置
//                params.leftMargin = getLeft() + offsetX;
//                params.topMargin = getTop() + offsetY;
//                setLayoutParams(params);
//                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();    //方法4：通过改变左外边距和上外边距的参数，改变位置
//                params.leftMargin = getLeft()+offsetX;
//                params.topMargin = getTop()+offsetY;
//                setLayoutParams(params);
                ((View)getParent()).scrollBy(-offsetX,-offsetY);        //方法5：通过scrollBy方法改变位置
                break;
            case MotionEvent.ACTION_UP:
                View viewGroup = (View) getParent();
                mScroller.startScroll(
                        viewGroup.getScrollX(),     //初始位置X
                        viewGroup.getScrollY(),     //初始位置Y
                        -viewGroup.getScrollX(),   //反向位移X
                        -viewGroup.getScrollY()     //反向位移Y
                );
                invalidate();
                break;
        }
        return true;
    }
}
