package com.zheteng123.androidheros_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToEmptyListView = (Button) findViewById(R.id.btn_to_empty_listview);
        btnToEmptyListView.setOnClickListener(this);

        Button btnToListViewMove = (Button) findViewById(R.id.btn_to_listview_move);
        btnToListViewMove.setOnClickListener(this);

        Button btnToListViewFlexible = (Button) findViewById(R.id.btn_to_flexible);
        btnToListViewFlexible.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_to_empty_listview:
                Intent intent = new Intent(this, EmptyListViewActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_to_listview_move:
                Intent intent2 = new Intent(this, ListViewMoveActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_to_flexible:
                Intent intent3 = new Intent(this, MyListViewActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
