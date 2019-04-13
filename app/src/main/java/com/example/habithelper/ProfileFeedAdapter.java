package com.example.habithelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfileFeedAdapter extends RecyclerView.Adapter<ProfileFeedAdapter.ProfileFeedViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<ProfileFeed> profileFeedList;

    Globals sharedData = Globals.getInstance();

    //getting the context and product list with constructor
    public ProfileFeedAdapter(Context mCtx, List<ProfileFeed> profileFeedList) {
        this.mCtx = mCtx;
        this.profileFeedList = profileFeedList;
    }

    @Override
    public ProfileFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_profile_feed, null);
        return new ProfileFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileFeedViewHolder holder, int position) {
        //getting the product of the specified position
        ProfileFeed profileFeed = profileFeedList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(profileFeed.getTitle());
        holder.profileName.setText(sharedData.getProfileName());

        if(sharedData.getProfilePicture() != null && profileFeedList.get(position).getImage() == R.drawable.profilepikture) {
            holder.imageView.setImageBitmap(sharedData.getProfilePicture());
        } else {
            holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(profileFeed.getImage()));
        }
    }

    @Override
    public int getItemCount() {
        return profileFeedList.size();
    }

    class ProfileFeedViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView profileName;
        ImageView imageView;

        public ProfileFeedViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            profileName = itemView.findViewById(R.id.profileName);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }

}





