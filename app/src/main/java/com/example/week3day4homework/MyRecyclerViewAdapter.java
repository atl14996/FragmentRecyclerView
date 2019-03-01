package com.example.week3day4homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    ArrayList<User> userArrayList;

    public MyRecyclerViewAdapter(ArrayList<User> userlist) {

        this.userArrayList = userlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_input, viewGroup, false));



    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder viewHolder, int i) {

        User currentUser = userArrayList.get(i);

        viewHolder.tvUsername.setText(currentUser.getUserName());
        viewHolder.tvEmail.setText(currentUser.getUserEmail());
        viewHolder.tvPassword.setText(currentUser.getUserPassword());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername;
        TextView tvEmail;
        TextView tvPassword;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvEnteredUserName);
            tvEmail = itemView.findViewById(R.id.tvEnteredEmail);
            tvPassword = itemView.findViewById(R.id.tvEnteredPassword);
        }
    }
}
