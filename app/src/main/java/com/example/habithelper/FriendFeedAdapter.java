package com.example.habithelper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendFeedAdapter extends RecyclerView.Adapter<FriendFeedAdapter.FriendFeedViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<FriendFeedFeed> friendFeedList;

    //getting the context and product list with constructor
    public FriendFeedAdapter(Context mCtx, List<FriendFeedFeed> friendFeedList) {
        this.mCtx = mCtx;
        this.friendFeedList = friendFeedList;
    }

    @Override
    public FriendFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_friend_feed, null);
        return new FriendFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendFeedViewHolder holder, int position) {
        //getting the product of the specified position
        FriendFeedFeed friendFeedFeed = friendFeedList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(friendFeedFeed.getTitle());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(friendFeedFeed.getImage()));
    }

    @Override
    public int getItemCount() {
        return friendFeedList.size();
    }

    class FriendFeedViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;

        public FriendFeedViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}





