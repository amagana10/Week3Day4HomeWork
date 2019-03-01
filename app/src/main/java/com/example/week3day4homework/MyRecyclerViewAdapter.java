package com.example.week3day4homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    ArrayList<User> users;

    public MyRecyclerViewAdapter(ArrayList<User> users1) {
        this.users = users1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User currentUserBeingPopulated = users.get(i);
        viewHolder.tvName.setText(currentUserBeingPopulated.getName());
        viewHolder.tvEmail.setText(currentUserBeingPopulated.getEmail());
        viewHolder.tvPassword.setText(currentUserBeingPopulated.getPassword());
        Log.d("TAG", "onBindViewHolder: item being rendered = " + i);
    }

    public void addUser(User user){
        users.add(user);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvEmail;
        TextView tvPassword;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPassword = itemView.findViewById(R.id.tvPassword);
        }
    }
}
