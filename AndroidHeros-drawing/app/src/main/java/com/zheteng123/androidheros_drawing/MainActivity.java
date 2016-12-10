package com.zheteng123.androidheros_drawing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int dip = DisplayUtil.px2dip(this, 10);
        Log.d(TAG, "onCreate: " + dip);
    }
}