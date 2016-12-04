package com.zheteng123.androidheros_customer_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created on 2016/12/4.
 */


public class MyTextView2 extends TextView {
    private int mViewWidth;
    private TextPaint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private int mTranslate;

    public MyTextView2(Context context) {
        super(context);
    }

    public MyTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyTextView2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(
                        0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{
                                Color.BLUE,
                                0xffffffff,
                                Color.BLUE
                        },
                        null,
                        Shader.TileMode.CLAMP
                );
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }
}
