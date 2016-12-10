# ʵ�ֻ��������ַ���

## layout ����
```java
// ��д View �� onTouchEvent ����
@Override
public boolean onTouchEvent(MotionEvent event) {
    int x = (int) event.getX();
    int y = (int) event.getY();

    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            // ��¼����������
            lastX = x;
            lastY = y;
            break;

        case MotionEvent.ACTION_MOVE:
            int offsetX = x - lastX;
            int offsetY = y - lastY;
            layout(
                    getLeft() + offsetX,
                    getTop() + offsetY,
                    getRight() + offsetX,
                    getBottom() + offsetY
            );
            break;
    }

    return true;
}
```

## offsetLeftAndRight() �� offsetTopAndBotton()
```java
offsetLeftAndRight(offsetX);
offsetTopAndBotton(offsetY);
```

## LayoutParams
```java
// ע�⿼�Ǹ���������
LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getLayoutParams();
layoutParams.leftMargin = getLeft() + offsetX;
layoutParams.topMargin = getTop() + offsetY;
setLayoutParams(layoutParams);
```

```java
// ����Ҫ���Ǹ�����
ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
layoutParams.leftMargin = getLeft() + offsetX;
layoutParams.topMargin = getTop() + offsetY;
setLayoutParams(layoutParams);
```

## scrollTo �� scrollBy
��������ƶ����� View �����ݣ����Ҫ�ƶ���ǰ View����Ҫ�� View �ĸ������в���
```java
int offsetX = x - lastX;
int offsetY = y - lastY;
((View)getParent()).scrollBy(-offsetX, -offsetY);  // srollBy �ο�ϵ�෴�������Ҫ��ƫ������Ϊ��ֵ
```

## Scroller
```java
private void initView(Context context) {
    setBackgroundColor(Color.BLUE);

    // ��ʼ�� Scroller
    mScroller = new Scroller(context);
}

@Override
public void computeScroll() {
    super.computeScroll();
    // �ж� Scroller �Ƿ�ִ�����
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
            // ��ָ�뿪ʱ��ִ�л�������
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
```