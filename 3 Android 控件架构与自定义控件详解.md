# 3.2 View 的测量
- 测量模式
    - EXACTLY 确定值，当我们将控件的值设置为具体数值，如 100dp 时，或者指定为 match_parent 时。
    - AT_MOST 最大值模式，当控件 layout_width 属性或 layout_height 属性指定为 wrap_content 时，控件大小随着子控件内容的变化而变化，此时控件的尺寸只要不超过父控件允许的最大尺寸即可。
    - UNSPECIFIED 不指定其大小测量模式
    
```java
@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    setMeasuredDimension(
            measureWidth(widthMeasureSpec),
            measureHeight(heightMeasureSpec)
    );
}

private int measureHeight(int heightMeasureSpec) {
    int result = 0;
    int specMode = MeasureSpec.getMode(heightMeasureSpec);
    int specSize = MeasureSpec.getSize(heightMeasureSpec);

    if (specMode == MeasureSpec.EXACTLY) {
        result = specSize;
    } else {
        result = 200;
        if (specMode == MeasureSpec.AT_MOST) {
            result = Math.min(result, specSize);
        }
    }

    return result;
}

private int measureWidth(int widthMeasureSpec) {
    int result = 0;
    int specMode = MeasureSpec.getMode(widthMeasureSpec);
    int specSize = MeasureSpec.getSize(widthMeasureSpec);

    if (specMode == MeasureSpec.EXACTLY) {
        result = specSize;
    } else {
        result = 200;
        if (specMode == MeasureSpec.AT_MOST) {
            result = Math.min(result, specSize);
        }
    }

    return result;
}
```

# 3.3 View 的绘制
装载画布：`Canvas canvas = new Canvas(bitmap);`
（这里暂时理解不了，等后续补充）

# 3.4 ViewGroup 的测量
当 ViewGroup 大小为 wrap_content 时，ViewGroup 就需要对子 View 进行遍历，获取子 View 的大小（调用子 View 的 Measure 方法），从而决定自己的大小。其他模式下通过具体的指定值来设置自身的大小。

# 3.5 ViewGroup 的绘制
ViewGroup 通常不需要绘制，如果不指定其背景颜色，onDraw() 方法将不会被调用。
ViewGroup 会使用 dispatchDraw() 方法来绘制其子 View（通过遍历调用每一个子 View 的绘制方法）。

# 3.6 自定义 View
重写 onDraw() 方法来绘制 View 的显示内容，如果该 View 需要使用 wrap_content 属性，那么还需重写 onMeasure() 方法。

比较重要的回调方法：

- onFinishInflate(): 从 XML 加载组件后回调
- onSizeChanged(): 组件大小改变时回调
- onMeasure(): 测量
- onLayout(): 回调该方法来确定显示的位置 
- onTouchEvent(): 监听到触摸事件时回调

## 3.6.1 对现有控件进行扩展

```java
@Override
protected void onDraw(Canvas canvas) {
    // 在回调父类方法前，实现自己的逻辑，对 TextView 来说即是在绘制文本内容前
    super.onDraw(canvas);
    // 在绘制文本内容后
}
```

***附件代码***：见 AndroidHeros-Customer-View/MyTextView 和 MyTextView2

## 3.6.2 创建复合控件
***附件代码***：见 AndroidHeros-Customer-View/TopBar