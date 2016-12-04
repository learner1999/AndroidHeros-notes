package com.zheteng123.androidheros_customer_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 在 TextView 绘制的文字之下，绘制两个不同大小的矩形
 * Created on 2016/12/4.
 */


public class MyTextView extends TextView {
    private Paint mPaint1, mPaint2;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 绘制外层蓝色矩形
        canvas.drawRect(
                0,
                0,
                getMeasuredWidth(),
                getMeasuredHeight(),
                mPaint1
        );

        // 绘制内层黄色矩形
        canvas.drawRect(
                10,
                10,
                getMeasuredWidth() - 10,
                getMeasuredHeight() - 10,
                mPaint2
        );

        canvas.save();

        // 在绘制文字前让 canvas 向右移动 10，以免文字和边框重叠
        canvas.translate(10, 0);

        // 调用父类方法来绘制文字
        super.onDraw(canvas);

        canvas.restore();
    }
}
