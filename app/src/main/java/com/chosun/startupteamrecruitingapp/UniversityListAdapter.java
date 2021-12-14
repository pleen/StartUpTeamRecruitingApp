package com.chosun.startupteamrecruitingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UniversityListAdapter extends BaseAdapter {
    //Adapter의 데이터 저장을 위한 list
    private List<University> items = new ArrayList<>();

    public UniversityListAdapter(List<University> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)로부터 위젯에 대한 참조 획득
        TextView textView = convertView.findViewById(R.id.tv_1);
        // Data Set(items)에서 position에 위치한 데이터 참조 획득 후 textview에 데이터 셋팅
        University listViewItem = items.get(pos);
        textView.setText(listViewItem.getUnivNm());

        return convertView;
    }

    public void convertList(List<University> list){
        items = list;
    }
}
