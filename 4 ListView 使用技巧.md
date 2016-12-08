# ListView 常用优化技巧
## 使用 ViewHolder 模式提高效率
```java
public final class ViewHolder {
    public ImageView img;
    public TextView title;
}
```

## 设置项目间分隔线
```XML
android:divider="@android:color/darker_gray"
android:dividerHeight="10dp"
```
设置为透明
```XML
android:divider="@null"
```

## 取消 Item 点击效果
下面两种方式都可以
```XML
android:listSelector="#00000000"
android:listSelector="@android:color/transparent"
```

## 设置 ListView 需要显示在第几项（跳到某一个位置）
瞬间完成
```java
listView.setSelection(N);
```

平滑移动
```java
mListView.smoothScrollBy(distance, duration);
mListView.smoothScrollByOffset(offset);
mListView.smoothScrollToPosition(index);
```

## 遍历 ListView 中的所有 Item
```java
for (int i = 0; i < mListView.getChildCount(); i++) {
    View view = mListView.getChildAt(i);
}
```

## 处理空 ListView
```java
ListView listView = (ListView) findViewById(R.id.lv_empty);
listView.setEmptyView(findViewById(R.id.iv_empty_view));
```

## ListView 滑动监听
- OnTouchListener

```java
mListView.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 触摸时操作
                Log.d(TAG, "onTouch: 接触屏幕");
                break;

            case MotionEvent.ACTION_MOVE:
                // 滑动时操作
                Log.d(TAG, "onTouch: 正在移动");
                break;

            case MotionEvent.ACTION_UP:
                // 离开时操作
                Log.d(TAG, "onTouch: 离开屏幕");
                break;
        }

        return false;
    }
});
```

- OnScrollListener
```java
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
```

## 具有弹性的 ListView
```java
// 继承 ListView，覆写 overScrollBy 方法
@Override
protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
    return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverDistance, isTouchEvent);  // 修改 maxOverDistance 的值即可
}
```

## 滑动显示隐藏 ListView
```java
// 动画部分看不懂。。。
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
```

## 动态改变 ListView 布局
继承 BaseAdapter，在 adapter 中用一个变量 mCurrentItem 记录被点击的 item，然后在 getView 中判断 position == mCurrentItem，来返回不同的 view
