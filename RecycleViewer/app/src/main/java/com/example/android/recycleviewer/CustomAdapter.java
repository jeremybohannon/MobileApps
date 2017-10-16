package com.example.android.recycleviewer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jeremybohannon on 10/16/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    ArrayList<CustomModel> customModel;

    public CustomAdapter(ArrayList<CustomModel> customModel) {
        this.customModel = customModel;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View customLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new CustomViewHolder(customLayout);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.name.setText(customModel.get(position).getName());
        holder.testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("TEST");
            }
        });

    }

    @Override
    public int getItemCount() {
        return customModel.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        Button testBtn;

        public CustomViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.nameView);
            testBtn = (Button) itemView.findViewById(R.id.testBtn);

        }
    }

}
