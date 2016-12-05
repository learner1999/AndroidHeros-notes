package com.zheteng123.androidheros_customer_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopBar topBar = (TopBar) findViewById(R.id.topbar);
        topBar.setOnTopbarClickListener(new TopBar.TopbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "左边的按钮", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "右边的按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
