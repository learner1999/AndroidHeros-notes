package com.zheteng123.androidheros_listview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.zheteng123.androidheros_listview.R;

import java.util.List;

/**
 * Created on 2016/12/7.
 */


public class FlexibleListViewAdapter extends ArrayAdapter<String> {

    private LayoutInflater mInflater;
    private int mResource;

    public FlexibleListViewAdapter(Context context, int resource) {
        super(context, resource);
        mInflater = LayoutInflater.from(context);
        mResource = resource;
    }

    public FlexibleListViewAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
        mInflater = LayoutInflater.from(context);
        mResource = resource;
    }

    public FlexibleListViewAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        mInflater = LayoutInflater.from(context);
        mResource = resource;
    }

    public FlexibleListViewAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
        mInflater = LayoutInflater.from(context);
        mResource = resource;
    }

    public FlexibleListViewAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mInflater = LayoutInflater.from(context);
        mResource = resource;
    }

    public FlexibleListViewAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
        mInflater = LayoutInflater.from(context);
        mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(mResource, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_num);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(getItem(position));

        return convertView;
    }

    public final class ViewHolder {
        TextView textView;
    }
}
