# 3.2 View �Ĳ���
- ����ģʽ
    - EXACTLY ȷ��ֵ�������ǽ��ؼ���ֵ����Ϊ������ֵ���� 100dp ʱ������ָ��Ϊ match_parent ʱ��
    - AT_MOST ���ֵģʽ�����ؼ� layout_width ���Ի� layout_height ����ָ��Ϊ wrap_content ʱ���ؼ���С�����ӿؼ����ݵı仯���仯����ʱ�ؼ��ĳߴ�ֻҪ���������ؼ���������ߴ缴�ɡ�
    - UNSPECIFIED ��ָ�����С����ģʽ
    
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

# 3.3 View �Ļ���
װ�ػ�����`Canvas canvas = new Canvas(bitmap);`
��������ʱ��ⲻ�ˣ��Ⱥ������䣩

# 3.4 ViewGroup �Ĳ���
�� ViewGroup ��СΪ wrap_content ʱ��ViewGroup ����Ҫ���� View ���б�������ȡ�� View �Ĵ�С�������� View �� Measure ���������Ӷ������Լ��Ĵ�С������ģʽ��ͨ�������ָ��ֵ����������Ĵ�С��

# 3.5 ViewGroup �Ļ���
ViewGroup ͨ������Ҫ���ƣ������ָ���䱳����ɫ��onDraw() ���������ᱻ���á�
ViewGroup ��ʹ�� dispatchDraw() �������������� View��ͨ����������ÿһ���� View �Ļ��Ʒ�������

# 3.6 �Զ��� View
��д onDraw() ���������� View ����ʾ���ݣ������ View ��Ҫʹ�� wrap_content ���ԣ���ô������д onMeasure() ������

�Ƚ���Ҫ�Ļص�������

- onFinishInflate(): �� XML ���������ص�
- onSizeChanged(): �����С�ı�ʱ�ص�
- onMeasure(): ����
- onLayout(): �ص��÷�����ȷ����ʾ��λ�� 
- onTouchEvent(): �����������¼�ʱ�ص�

## 3.6.1 �����пؼ�������չ

```java
@Override
protected void onDraw(Canvas canvas) {
    // �ڻص����෽��ǰ��ʵ���Լ����߼����� TextView ��˵�����ڻ����ı�����ǰ
    super.onDraw(canvas);
    // �ڻ����ı����ݺ�
}
```

***��������***���� AndroidHeros-Customer-View/MyTextView �� MyTextView2

## 3.6.2 �������Ͽؼ�
***��������***���� AndroidHeros-Customer-View/TopBar