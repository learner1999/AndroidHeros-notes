package com.zheteng123.androidheros_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zheteng123.androidheros_listview.adapter.FlexibleListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyListViewActivity extends AppCompatActivity {

    private ListView mListView;
    private FlexibleListViewAdapter mArrayAdapter;
    private List<String> mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);

        mListView = (ListView) findViewById(R.id.lv_flexible);

        initData();
        mArrayAdapter = new FlexibleListViewAdapter(this, R.layout.item, mStrings);
        mListView.setAdapter(mArrayAdapter);
        mArrayAdapter.notifyDataSetChanged();
    }

    private void initData() {
        mStrings = new ArrayList<>();
        for(int i = 1; i < 100; i++) {
            mStrings.add(i + "");
        }
    }
}
