package com.example.habithelper;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class HabitPageHabitAdapter extends RecyclerView.Adapter<HabitPageHabitAdapter.HabitPageHabitViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Habit> HabitPageHabitList;

    Globals sharedData = Globals.getInstance();

    //getting the context and product list with constructor
    public HabitPageHabitAdapter(Context mCtx, List<Habit> HabitPageHabitList) {
        this.mCtx = mCtx;
        this.HabitPageHabitList = HabitPageHabitList;
    }

    @Override
    public HabitPageHabitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_habit, null);
        return new HabitPageHabitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HabitPageHabitViewHolder holder, int position) {
        //getting the product of the specified position
        Habit Habit = HabitPageHabitList.get(position);

        //binding the data with the viewholder views
        holder.name.setText(Habit.getName());
        holder.description.setText(Habit.getDescription());
        holder.frequency.setText(Habit.getFrequency());
        holder.cost.setText(Habit.getCost());
        holder.lockImageView.setImageDrawable(mCtx.getResources().getDrawable(Habit.getLockImage()));
        holder.actionImageView.setImageDrawable(mCtx.getResources().getDrawable(Habit.getActionImage()));
        if (!Habit.getOwner().equals(sharedData.getProfileName())) {
            LinearLayout.LayoutParams params0 = new LinearLayout.LayoutParams(
                    320,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params0.setMargins(0, 0, 0, 0);
            ((LinearLayout) holder.name.getParent()).setLayoutParams(params0);

            holder.see_pic.setVisibility(View.INVISIBLE);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    30,
                    0
            );
            params.setMargins(0, 0, 0, 0);
            holder.see_pic.setLayoutParams(params);
        }
        if(Habit.getIsBad()) {
            holder.name.setTag("Bad");
            holder.see_pic.setTag(R.id.habit_description, "Bad");
            holder.see_pic.setTag(R.id.habit_name, Habit.getName());
            holder.actionImageView.setTag(Habit.getName());
            holder.name.setTextColor(Color.argb(255, 255, 0, 0));
        } else {
            holder.name.setTag("Good");
            holder.see_pic.setTag(R.id.habit_description, "Good");
            holder.see_pic.setTag(R.id.habit_name, Habit.getName());
            holder.actionImageView.setTag(Habit.getName());
            holder.name.setTextColor(Color.argb(255, 0, 180, 0));
        }
    }

    @Override
    public int getItemCount() {
        return HabitPageHabitList.size();
    }

    class HabitPageHabitViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView description;
        TextView frequency;
        TextView cost;
        ImageView lockImageView;
        ImageView see_pic;
        ImageView actionImageView;

        public HabitPageHabitViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.habit_name);
            description = itemView.findViewById(R.id.habit_description);
            frequency = itemView.findViewById(R.id.habit_frequency);
            cost = itemView.findViewById(R.id.habit_cost);
            lockImageView = itemView.findViewById(R.id.lock_pic);
            actionImageView = itemView.findViewById(R.id.action_pic);
            see_pic = itemView.findViewById(R.id.see_pic);
        }
    }
}





