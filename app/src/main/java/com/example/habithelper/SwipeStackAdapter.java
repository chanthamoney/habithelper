package com.example.habithelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SwipeStackAdapter extends BaseAdapter {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<String> mData;
    private List<Integer> toRemove;

    //getting the context and product list with constructor
    public SwipeStackAdapter(Context mCtx, List<String> data) {
        this.mCtx = mCtx;
        this.mData = data;
        toRemove = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        convertView = inflater.inflate(R.layout.card, parent, false);
        TextView textViewCard = (TextView) convertView.findViewById(R.id.textViewCard);
        textViewCard.setText(mData.get(position));
        return convertView;
    }

    public void remove(int position) {
        toRemove.add(new Integer(position));
    }

    public void reset() {
        int j = 0;
        for (int i = 0; i < toRemove.size(); i++) {
            mData.remove(toRemove.get(i) - j);
            j++;
        }
        if (mData.isEmpty()) {
            mData.add("No Notificaitons!");
        }
        toRemove.clear();

        this.notifyDataSetChanged();
    }
}





