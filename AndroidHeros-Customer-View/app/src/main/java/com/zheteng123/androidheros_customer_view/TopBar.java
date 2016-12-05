package com.zheteng123.androidheros_customer_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created on 2016/12/5.
 */


public class TopBar extends RelativeLayout {
    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;
    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;
    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;
    private Button mLeftButton, mRightButton;
    private TextView mTitleView;
    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitleParams;
    private TopbarClickListener mListener;

    public TopBar(Context context) {
        super(context);
        initView();
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        getCustomerAttr(attrs);
        initView();
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getCustomerAttr(attrs);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TopBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        getCustomerAttr(attrs);
        initView();
    }

    /**
     * 获取用户自定义配置项
     * @param attrs
     */
    private void getCustomerAttr(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.TopBar);

        mLeftTextColor = ta.getColor(
                R.styleable.TopBar_leftTextColor,
                0
        );
        mLeftBackground = ta.getDrawable(
                R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);

        mRightTextColor = ta.getColor(
                R.styleable.TopBar_rightTextColor,
                0
        );
        mRightBackground = ta.getDrawable(
                R.styleable.TopBar_rightBackground);
        mRightText = ta.getString(R.styleable.TopBar_rightText);

        mTitleTextSize = ta.getDimension(
                R.styleable.TopBar_titleTextSize,
                10
        );
        mTitleTextColor = ta.getColor(
                R.styleable.TopBar_titleTextColor,
                0
        );
        mTitle = ta.getString(R.styleable.TopBar_title);

        ta.recycle();
    }

    private void initView() {
        mLeftButton = new Button(getContext());
        mRightButton = new Button(getContext());
        mTitleView = new TextView(getContext());

        // 为创建的组件元素赋值
        mLeftButton.setTextColor(mLeftTextColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mLeftButton.setBackground(mLeftBackground);
        }
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mRightButton.setBackground(mRightBackground);
        }
        mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        // 为组件设置相应的布局元素
        mLeftParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);

        // 添加至 TopBar
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        mTitleParams.addRule(CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);
    }

    /**
     * 暴露接口给开发者，支持自定义左右按钮点击事件
     * @param listener
     */
    public void setOnTopbarClickListener(TopbarClickListener listener) {
        mListener = listener;
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.rightClick();
            }
        });
    }

    public void setButtonVisible(int id, boolean flag) {
        if (flag) {
            if (id == 0) {
                mLeftButton.setVisibility(VISIBLE);
            } else {
                mRightButton.setVisibility(VISIBLE);
            }
        } else {
            if (id == 0) {
                mLeftButton.setVisibility(GONE);
            } else {
                mRightButton.setVisibility(GONE);
            }
        }
    }

    public interface TopbarClickListener {
        // 左按钮点击事件
        void leftClick();

        // 右按钮点击事件
        void rightClick();
    }
}
