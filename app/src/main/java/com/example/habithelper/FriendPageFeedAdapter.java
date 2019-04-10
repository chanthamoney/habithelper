package com.example.habithelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendPageFeedAdapter extends RecyclerView.Adapter<FriendPageFeedAdapter.FriendPageFeedViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<FriendPageFeed> FriendPageFeedList;

    //getting the context and product list with constructor
    public FriendPageFeedAdapter(Context mCtx, List<FriendPageFeed> FriendPageFeedList) {
        this.mCtx = mCtx;
        this.FriendPageFeedList = FriendPageFeedList;
    }

    @Override
    public FriendPageFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_profile_feed, null);
        return new FriendPageFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendPageFeedViewHolder holder, int position) {
        //getting the product of the specified position
        FriendPageFeed friendPageFeed = FriendPageFeedList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(friendPageFeed.getTitle());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(friendPageFeed.getImage()));
    }

    @Override
    public int getItemCount() {
        return FriendPageFeedList.size();
    }

    class FriendPageFeedViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;

        public FriendPageFeedViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}





