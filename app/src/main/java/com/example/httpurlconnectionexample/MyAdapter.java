package com.example.httpurlconnectionexample;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Lead> data;

    public MyAdapter(List<Lead> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.source_Textview.setText(data.get(position).getSource());
        holder.status_Textview.setText(data.get(position).getStatus());
        holder.reasondq_TextView.setText(data.get(position).getReason_disqualified());
        holder.type_Textview.setText(data.get(position).getType());
        holder.linkedin_Textview.setText(data.get(position).getLinkedin());
        holder.role_Textview.setText(data.get(position).getRole());
        holder.rating_TextView.setText(data.get(position).getRating());
        holder.id_Textview.setText("Lead: "+data.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView source_Textview, status_Textview, reasondq_TextView, type_Textview, linkedin_Textview, role_Textview, rating_TextView, id_Textview;
        public MyViewHolder(View itemView) {
            super(itemView);
            source_Textview = (TextView) itemView.findViewById(R.id.source_textview);
            status_Textview = (TextView) itemView.findViewById(R.id.status_textview);
            reasondq_TextView = (TextView) itemView.findViewById(R.id.reason_disqualified_textview);
            type_Textview = (TextView) itemView.findViewById(R.id.type_textview);
            linkedin_Textview = (TextView) itemView.findViewById(R.id.linkedin_textview);
            role_Textview = (TextView) itemView.findViewById(R.id.role_textview);
            rating_TextView = (TextView) itemView.findViewById(R.id.rating_textview);
            id_Textview = (TextView) itemView.findViewById(R.id.lead_title_textview);
        }
    }
}