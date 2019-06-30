package com.example.listviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    //data container;
    ArrayList<Characters> list;
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<Characters> list) {
        super();
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CharacterHandler handler = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_layout, null);
            handler = new CharacterHandler();
            handler.iv = (ImageView) convertView.findViewById(R.id.imageView);
            handler.name = (TextView) convertView.findViewById(R.id.name);
            handler.course = (TextView) convertView.findViewById(R.id.course);
            convertView.setTag(handler);
        }else handler = (CharacterHandler)convertView.getTag();
        handler.iv.setImageResource(list.get(position).getImg());
        handler.name.setText(list.get(position).getName());
        handler.course.setText(list.get(position).getCourse());

        return convertView;
    }

    static class CharacterHandler{
        ImageView iv;
        TextView name, course;
    }
}
