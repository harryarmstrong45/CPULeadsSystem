package com.example.httpurlconnectionexample;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/**
 Custom RecyclerView adapter for displaying a list of Lead objects.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Lead> data;
    private String API_URL = API.getApiUrl(API.CONVERT_LEAD);

    /**
     Constructs a new MyAdapter with the specified data.
     @param data The list of Lead objects to be displayed.
     */
    public MyAdapter(List<Lead> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Bind the data to the views in the ViewHolder
        holder.source_Textview.setText(data.get(position).getSource());
        holder.status_Textview.setText(data.get(position).getStatus());
        holder.reasondq_TextView.setText(data.get(position).getReason_disqualified());
        holder.type_Textview.setText(data.get(position).getType());
        holder.linkedin_Textview.setText(data.get(position).getLinkedin());
        holder.role_Textview.setText(data.get(position).getRole());
        holder.rating_TextView.setText(data.get(position).getRating());
        holder.id_Textview.setText("Lead: "+data.get(position).getId());
        // Set click listener for the edit button
        holder.button_edit.setOnClickListener(v -> {
            Lead lead = data.get(position);
            Intent intent = new Intent(v.getContext(), NewUpdateLeadActivity.class);
            //Passing the lead object to new activity
            intent.putExtra("selected_lead", lead);
            v.getContext().startActivity(intent);
        });

        holder.button_convert.setOnClickListener(v -> {
            URLConnectionPostHandler urlConnectionPostHandler = new URLConnectionPostHandler();
            urlConnectionPostHandler.setDataDownloadListener(new URLConnectionPostHandler.DataDownloadListener() {
                @Override
                public void dataDownloadedSuccessfully(Object data) {
                    // Handle successful result
                    Toast.makeText(v.getContext(), data.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void dataDownloadFailed() {
                    // Handle unsuccessful result
                    Toast.makeText(v.getContext(), "Error in API", Toast.LENGTH_SHORT).show();
                }
            });
            urlConnectionPostHandler.execute(API_URL, "Lead_ID=" + data.get(position).getId());
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    /**
     ViewHolder class for caching the views of each item in the RecyclerView.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView source_Textview, status_Textview, reasondq_TextView, type_Textview, linkedin_Textview, role_Textview, rating_TextView, id_Textview;
        public Button button_edit, button_convert;
        /**
         Constructs a new MyViewHolder with the specified itemView.
         @param itemView The view representing each item in the RecyclerView.
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            source_Textview = itemView.findViewById(R.id.source_textview);
            status_Textview = itemView.findViewById(R.id.status_textview);
            reasondq_TextView = itemView.findViewById(R.id.reason_disqualified_textview);
            type_Textview = itemView.findViewById(R.id.type_textview);
            linkedin_Textview = itemView.findViewById(R.id.linkedin_textview);
            role_Textview = itemView.findViewById(R.id.role_textview);
            rating_TextView = itemView.findViewById(R.id.rating_textview);
            id_Textview = itemView.findViewById(R.id.lead_title_textview);
            button_edit = itemView.findViewById(R.id.button_edit);
            button_convert = itemView.findViewById(R.id.button_convert);
        }
    }
}