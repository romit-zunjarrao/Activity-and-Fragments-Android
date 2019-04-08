package com.example.activityandfragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ListViewAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<AnimalModalClass> mList;

    public ListViewAdapter(Context mContext, ArrayList<AnimalModalClass> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_row_layout,parent,false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }
        else
        {
            vh = (ViewHolder)convertView.getTag();
        }
        AnimalModalClass animal = mList.get(position);
        vh.animalImage.setImageBitmap(animal.animalImage);
        vh.animalName.setText(animal.animalName);
        vh.animalName.setText(animal.animalBiography);
        return convertView;
    }

    class ViewHolder
    {
        ImageView animalImage;
        TextView animalName;
        TextView animalBiography;
        TextView includeImageTextView;
        CheckBox checkBox;

        public ViewHolder(View view) {
            this.animalImage = view.findViewById(R.id.animalImage);
            this.animalName = view.findViewById(R.id.animalName);
            this.animalBiography = view.findViewById(R.id.animalBiography);
            this.includeImageTextView = view.findViewById(R.id.includeImageTextView);
            this.checkBox = view.findViewById(R.id.animalImageShowCheckBox);
        }
    }
}
