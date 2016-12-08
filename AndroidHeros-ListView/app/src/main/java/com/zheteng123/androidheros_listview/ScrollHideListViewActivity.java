package com.zheteng123.androidheros_listview;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.zheteng123.androidheros_listview.adapter.FlexibleListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScrollHideListViewActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ListView mListView;
    private FlexibleListViewAdapter mArrayAdapter;
    private List<String> mStrings;

    private int mTouchSlop;
    private float mFirstY, mCurrentY;
    private int direction;
    private boolean mShow;

    private ObjectAnimator mAnimator;

    View.OnTouchListener myTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    if (mCurrentY - mFirstY > mTouchSlop) {
                        direction = 0;// down
                    } else if (mFirstY - mCurrentY > mTouchSlop) {
                        direction = 1;// up
                    }
                    if (direction == 1) {
                        if (mShow) {
                            toolbarAnim(1);//hide
                            mShow = !mShow;
                        }
                    } else if (direction == 0) {
                        if (!mShow) {
                            toolbarAnim(0);//show
                            mShow = !mShow;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_hide_list_view);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mListView = (ListView) findViewById(R.id.lv_hide);

        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(
                        R.dimen.abc_action_bar_default_height_material)));
        mListView.addHeaderView(header);

        mListView.setOnTouchListener(myTouchListener);

        initData();
        mArrayAdapter = new FlexibleListViewAdapter(this, R.layout.item, mStrings);
        mListView.setAdapter(mArrayAdapter);
        mArrayAdapter.notifyDataSetChanged();
    }

    private void initData() {
        mStrings = new ArrayList<>();
        for(int i = 1; i < 100; i++) {
            mStrings.add(i + "");
        }
    }

    private void toolbarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (flag == 0) {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,
                    "translationY", mToolbar.getTranslationY(), 0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,
                    "translationY", mToolbar.getTranslationY(),
                    -mToolbar.getHeight());
        }
        mAnimator.start();
    }
}
