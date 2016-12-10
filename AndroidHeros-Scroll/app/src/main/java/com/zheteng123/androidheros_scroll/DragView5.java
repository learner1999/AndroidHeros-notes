package com.zheteng123.androidheros_scroll;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created on 2016/12/9.
 */


public class DragView5 extends View {
    private Scroller mScroller;
    private int lastX, lastY;

    public DragView5(Context context) {
        super(context);
        initView(context);
    }

    public DragView5(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragView5(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DragView5(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(Color.BLUE);

        // 初始化 Scroller
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        // 判断 Scroller 是否执行完毕
        if (mScroller.computeScrollOffset()) {
            ((View)getParent()).scrollTo(
                    mScroller.getCurrX(),
                    mScroller.getCurrY()
            );
            invalidate();
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int)event.getX();
                lastY = (int)event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ((View)getParent()).scrollBy(-offsetX, -offsetY);
                break;

            case MotionEvent.ACTION_UP:
                // 手指离开时，执行滑动过程
                View viewGroup = ((View)getParent());
                mScroller.startScroll(
                        viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY(),
                        3000
                );
                invalidate();
                break;
        }

        return true;
    }
}
