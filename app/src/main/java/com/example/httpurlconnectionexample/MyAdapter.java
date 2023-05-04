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
        holder.source_Txt_V.setText(data.get(position).getSource());
        holder.status_Txt_V.setText(data.get(position).getStatus());
        holder.reason_Txt_V.setText(data.get(position).getReason_disqualified());
        holder.type_Txt_V.setText(data.get(position).getType());
        holder.linkedin_Txt_V.setText(data.get(position).getLinkedin());
        holder.role_Txt_V.setText(data.get(position).getRole());
        holder.rating_Txt_V.setText(data.get(position).getRating());
        holder.id_Txt_V.setText("Lead: "+data.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView source_Txt_V;
        public TextView status_Txt_V;
        public TextView reason_Txt_V;
        public TextView type_Txt_V;
        public TextView linkedin_Txt_V;
        public TextView role_Txt_V;
        public TextView rating_Txt_V;
        public TextView id_Txt_V;

        public MyViewHolder(View itemView) {
            super(itemView);
            source_Txt_V = (TextView) itemView.findViewById(R.id.source_textview);
            status_Txt_V = (TextView) itemView.findViewById(R.id.status_textview);
            reason_Txt_V = (TextView) itemView.findViewById(R.id.reason_disqualified_textview);
            type_Txt_V = (TextView) itemView.findViewById(R.id.type_textview);
            linkedin_Txt_V = (TextView) itemView.findViewById(R.id.linkedin_textview);
            role_Txt_V = (TextView) itemView.findViewById(R.id.role_textview);
            rating_Txt_V = (TextView) itemView.findViewById(R.id.rating_textview);
            id_Txt_V = (TextView) itemView.findViewById(R.id.lead_title_textview);
        }
    }
}