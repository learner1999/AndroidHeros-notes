# ListView �����Ż�����
## ʹ�� ViewHolder ģʽ���Ч��
```java
public final class ViewHolder {
    public ImageView img;
    public TextView title;
}
```

## ������Ŀ��ָ���
```XML
android:divider="@android:color/darker_gray"
android:dividerHeight="10dp"
```
����Ϊ͸��
```XML
android:divider="@null"
```

## ȡ�� Item ���Ч��
�������ַ�ʽ������
```XML
android:listSelector="#00000000"
android:listSelector="@android:color/transparent"
```

## ���� ListView ��Ҫ��ʾ�ڵڼ������ĳһ��λ�ã�
˲�����
```java
listView.setSelection(N);
```

ƽ���ƶ�
```java
mListView.smoothScrollBy(distance, duration);
mListView.smoothScrollByOffset(offset);
mListView.smoothScrollToPosition(index);
```

## ���� ListView �е����� Item
```java
for (int i = 0; i < mListView.getChildCount(); i++) {
    View view = mListView.getChildAt(i);
}
```

## ����� ListView
```java
ListView listView = (ListView) findViewById(R.id.lv_empty);
listView.setEmptyView(findViewById(R.id.iv_empty_view));
```

## ListView ��������
- OnTouchListener

```java
mListView.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // ����ʱ����
                Log.d(TAG, "onTouch: �Ӵ���Ļ");
                break;

            case MotionEvent.ACTION_MOVE:
                // ����ʱ����
                Log.d(TAG, "onTouch: �����ƶ�");
                break;

            case MotionEvent.ACTION_UP:
                // �뿪ʱ����
                Log.d(TAG, "onTouch: �뿪��Ļ");
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
                // ����ֹͣʱ
                Log.d(TAG, "onScrollStateChanged: ����ֹͣ");
                break;

            case SCROLL_STATE_TOUCH_SCROLL:
                // ���ڹ���
                Log.d(TAG, "onScrollStateChanged: ���ڹ���");
                break;

            case SCROLL_STATE_FLING:
                // ��ָ�׶�
                Log.d(TAG, "onScrollStateChanged: ��ָ�׶�");
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

## ���е��Ե� ListView
```java
// �̳� ListView����д overScrollBy ����
@Override
protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
    return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverDistance, isTouchEvent);  // �޸� maxOverDistance ��ֵ����
}
```

## ������ʾ���� ListView
```java
// �������ֿ�����������
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

## ��̬�ı� ListView ����
�̳� BaseAdapter���� adapter ����һ������ mCurrentItem ��¼������� item��Ȼ���� getView ���ж� position == mCurrentItem�������ز�ͬ�� view
