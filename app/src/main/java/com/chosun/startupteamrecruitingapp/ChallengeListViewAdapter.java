package com.chosun.startupteamrecruitingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ChallengeListViewAdapter extends BaseAdapter {
    //private List<ChallengeListViewItem> listViewItems = new ArrayList<>();
    private List<ChallengeDTO> listViewItems = new ArrayList<>();

    public ChallengeListViewAdapter(List<ChallengeDTO> listViewItems) {
        this.listViewItems = listViewItems;
    }

    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    /*public void addItem(Drawable icon, String title, String desc) {
        //ChallengeListViewItem item = new ChallengeListViewItem();
        ChallengeDTO item = new ChallengeDTO();

        //item.setFile_seq(icon);
        item.setTitleStr(title);
        item.setHostStr(desc);

        listViewItems.add(item);
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.challenge_list_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.challenge_img) ;
        TextView title = convertView.findViewById(R.id.challenge_title);
        TextView period = convertView.findViewById(R.id.challenge_period);
        TextView qualifi = convertView.findViewById(R.id.challenge_qualifi);

        // Data Set(items)에서 position에 위치한 데이터 참조 획득 후 textview에 데이터 셋팅
        //ChallengeListViewItem listViewItem = listViewItems.get(pos);
        ChallengeDTO listViewItem = listViewItems.get(pos);
        title.setText(listViewItem.getTitle());
        period.setText(listViewItem.getPeriod());
        qualifi.setText("지원조건 : " + listViewItem.getQualifi());
        Glide.with(context)
                .load("http://222.102.60.63:8080/startup/display?file="+listViewItem.getFile_path()+"/"+listViewItem.getFile_stored_nm())
                .into(iconImageView);
        return convertView;
    }
}
