package com.android.acadgild.fragmentlistdetails103.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.acadgild.fragmentlistdetails103.R;
import com.android.acadgild.fragmentlistdetails103.bean.CustomHandler;

import java.util.ArrayList;




/**
 * Created by Jal on 20-07-2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<CustomHandler> data;
    LayoutInflater inflater;

    //Constucter to get context and model data to set on UI
    public CustomAdapter(Context context, ArrayList<CustomHandler> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            //Inflate Custom Row view
            convertView = inflater.inflate(R.layout.custom_row, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.detail = (TextView) convertView.findViewById(R.id.detail);
            holder.image = (ImageView) convertView.findViewById(R.id.image);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //holder.view.setBackgroundColor(ContextCompat.getColor(context, colors[position % 6]));
        //Setting Title, Details, Image to UI List Components
        holder.title.setText(data.get(position).getTitle());
        holder.detail.setText(data.get(position).getDetail());
        holder.image.setImageResource(data.get(position).getImage());
        return convertView;
    }


    public class ViewHolder {
        TextView title, detail;
        ImageView image;
    }


}