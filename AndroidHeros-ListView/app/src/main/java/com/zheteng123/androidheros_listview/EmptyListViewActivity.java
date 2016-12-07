package com.zheteng123.androidheros_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class EmptyListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_list_view);

        ListView listView = (ListView) findViewById(R.id.lv_empty);
        listView.setEmptyView(findViewById(R.id.iv_empty_view));
    }
}
