package com.zheteng123.androidheros_drawing;

import android.content.Context;

/**
 * Created on 2016/12/10.
 */


public class DisplayUtil {

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
