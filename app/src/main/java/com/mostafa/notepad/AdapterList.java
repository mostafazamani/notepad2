package com.mostafa.notepad;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.*;
import java.util.List;


public class AdapterList extends ArrayAdapter<txt> {
    private List<txt> txtList;
    Context context;

    public AdapterList(Context context, List<txt> text) {
        super(context, R.layout.list_view,0,text);
        this.context =context;
        this.txtList = text;
    }



    @NonNull
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        ViewHolder viewHolder ;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view,parent , false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.fill(position);
        return convertView;
    }



    public class ViewHolder{
        TextView textView;

        public ViewHolder(View v) {
            textView = (TextView) v.findViewById(R.id.tv_list);

        }
        public void fill(int position){
            txt text = txtList.get(position);
            textView.setText(text.toString());
        }
    }
}
