package com.zheteng123.androidheros_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

public class ListViewMoveActivity extends AppCompatActivity {

    private static final String TAG = "ListViewMoveActivity";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_move);

        mListView = (ListView) findViewById(R.id.lv_move);

//        mListView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        // 触摸时操作
//                        Log.d(TAG, "onTouch: 接触屏幕");
//                        break;
//
//                    case MotionEvent.ACTION_MOVE:
//                        // 滑动时操作
//                        Log.d(TAG, "onTouch: 正在移动");
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                        // 离开时操作
//                        Log.d(TAG, "onTouch: 离开屏幕");
//                        break;
//                }
//
//                return false;
//            }
//        });

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_IDLE:
                        // 滑动停止时
                        Log.d(TAG, "onScrollStateChanged: 滑动停止");
                        break;

                    case SCROLL_STATE_TOUCH_SCROLL:
                        // 正在滚动
                        Log.d(TAG, "onScrollStateChanged: 正在滚动");
                        break;

                    case SCROLL_STATE_FLING:
                        // 手指抛动
                        Log.d(TAG, "onScrollStateChanged: 手指抛动");
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView absListView,
                                 int firstVisibleItem,
                                 int visibleItemCount,
                                 int totalItemCount) {
                Log.d(TAG, "onScroll: " +
                        "[firstVisibleItem=" +
                        firstVisibleItem +
                        ", visibleItemCount=" +
                        visibleItemCount +
                        ", totalItemCount=" +
                        totalItemCount +
                        "]");
            }
        });
    }
}
