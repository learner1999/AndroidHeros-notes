package com.zheteng123.androidheros_drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created on 2016/12/10.
 */


public class ClockView extends View {
    private int mWidth;
    private int mHeight;

    private Paint mPaintCircle;
    private Paint mPaintDegree;
    private Paint mPaintHour;
    private Paint mPaintMinute;

    public ClockView(Context context) {
        super(context);
        init();
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaintCircle = new Paint();
        mPaintDegree = new Paint();
        mPaintHour = new Paint();
        mPaintMinute = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setStrokeWidth(5);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, mPaintCircle);

        mPaintCircle.setStrokeWidth(3);
        for(int i = 0; i < 12; i++) {

            String degree = String.valueOf(i);

            if (i == 0 || i == 3 || i == 6 || i == 9) {
                mPaintDegree.setStrokeWidth(5);
                mPaintDegree.setTextSize(30);
                canvas.drawLine(
                        mWidth / 2,
                        mHeight / 2 - mWidth / 2,
                        mWidth / 2,
                        mHeight / 2 - mWidth / 2 + 60,
                        mPaintDegree
                );

                canvas.drawText(
                        degree,
                        mWidth / 2 - mPaintDegree.measureText(degree) / 2,
                        mHeight / 2 - mWidth / 2 + 90,
                        mPaintDegree
                );

            } else {
                mPaintDegree.setStrokeWidth(3);
                mPaintDegree.setTextSize(15);
                canvas.drawLine(
                        mWidth / 2,
                        mHeight / 2 - mWidth / 2,
                        mWidth / 2,
                        mHeight / 2 - mWidth / 2 + 30,
                        mPaintDegree
                );
                canvas.drawText(
                        degree,
                        mWidth / 2 - mPaintDegree.measureText(degree) / 2,
                        mHeight / 2 - mWidth / 2 + 60,
                        mPaintDegree

                );
            }

            canvas.rotate(30, mWidth / 2, mHeight / 2);
        }

        mPaintHour.setStrokeWidth(20);
        mPaintMinute.setStrokeWidth(10);
//        canvas.save();
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawLine(0, 0, 100, 100, mPaintHour);
        canvas.drawLine(0, 0, 100, 200, mPaintMinute);
//        canvas.restore();

    }
}
