# 实现滑动的七种方法

## layout 方法
```java
// 覆写 View 的 onTouchEvent 方法
@Override
public boolean onTouchEvent(MotionEvent event) {
    int x = (int) event.getX();
    int y = (int) event.getY();

    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            // 记录触摸点坐标
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

## offsetLeftAndRight() 与 offsetTopAndBotton()
```java
offsetLeftAndRight(offsetX);
offsetTopAndBotton(offsetY);
```

## LayoutParams
```java
// 注意考虑父布局类型
LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getLayoutParams();
layoutParams.leftMargin = getLeft() + offsetX;
layoutParams.topMargin = getTop() + offsetY;
setLayoutParams(layoutParams);
```

```java
// 不需要考虑父布局
ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
layoutParams.leftMargin = getLeft() + offsetX;
layoutParams.topMargin = getTop() + offsetY;
setLayoutParams(layoutParams);
```

## scrollTo 与 scrollBy
这个方法移动的是 View 的内容，如果要移动当前 View，需要在 View 的父布局中操作
```java
int offsetX = x - lastX;
int offsetY = y - lastY;
((View)getParent()).scrollBy(-offsetX, -offsetY);  // srollBy 参考系相反，因此需要将偏移量改为负值
```

## Scroller
```java
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
```