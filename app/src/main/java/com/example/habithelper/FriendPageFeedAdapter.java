package com.example.habithelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class FriendPageFeedAdapter extends RecyclerView.Adapter<FriendPageFeedAdapter.FriendPageFeedViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<FriendPageFeed> friendPageFeedList;

    //getting the context and product list with constructor
    public FriendPageFeedAdapter(Context mCtx, List<FriendPageFeed> friendPageFeedList) {
        this.mCtx = mCtx;
        this.friendPageFeedList = friendPageFeedList;
    }

    @Override
    public FriendPageFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_friend_feed, null);
        return new FriendPageFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendPageFeedViewHolder holder, int position) {
        //getting the product of the specified position
        FriendPageFeed friendPageFeed = friendPageFeedList.get(position);

        //binding the data with the viewholder views
        holder.name.setText(friendPageFeed.getName());
        holder.message.setText(friendPageFeed.getMessage());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(friendPageFeed.getImage()));
        holder.linearlayout.setTag(friendPageFeed.getName());
    }

    @Override
    public int getItemCount() {
        return friendPageFeedList.size();
    }

    class FriendPageFeedViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView message;
        ImageView imageView;
        LinearLayout linearlayout;

        public FriendPageFeedViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.friendname);
            message = itemView.findViewById(R.id.friendmessage);
            imageView = itemView.findViewById(R.id.imageView);
            linearlayout = itemView.getRootView().findViewById(R.id.fll);
        }
    }
}





