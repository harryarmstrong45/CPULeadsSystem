package com.example.httpurlconnectionexample;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MyAdapter adapter;

    String url_api_view = API.getApiUrl(API.VIEW_TABLE);

    FloatingActionButton fab;

    /**
     * Resumes the activity after it has been tabbed out off or stopped in anyway
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewUpdateLeadActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onResume() {
        super.onResume();
        ViewLeads();
    }

    /**
     * Gets all leads from the API, puts them in a JSON decoder and converts them to a string.
     */
    private void ViewLeads() {
        URLConnectionGetHandler uRLConnectionGetHandler = new URLConnectionGetHandler();
        uRLConnectionGetHandler.setDataDownloadListener(new URLConnectionGetHandler.DataDownloadListener() {
            @Override
            public void dataDownloadedSuccessfully(Object data) {
                // handler result
                jsonDecoder(data.toString());
            }

            @Override
            public void dataDownloadFailed() {
                Toast.makeText(MainActivity.this, "No records found.", Toast.LENGTH_SHORT).show();

            }
        });
        uRLConnectionGetHandler.execute(url_api_view);
    }

    /**
     * JSON Decoder for the API Data, creates a new JSON object with data from the API
     * @param json_string String of data downloaded from API
     */
    public void jsonDecoder(String json_string) {

        try {
            json_string = json_string.substring(json_string.indexOf("{"));

            recyclerView = (RecyclerView) this.findViewById(R.id.Lead_RCV);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            List<Lead> items = new ArrayList<>();
            JSONObject root = new JSONObject(json_string);

            JSONArray array = root.getJSONArray("leads");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Lead newLead = new Lead(
                        object.getString("Lead_ID"),
                        object.getString("source"),
                        object.getString("status"),
                        object.getString("reason_disqualified"),
                        object.getString("type"),
                        object.getString("vendor_id"),
                        object.getString("linkedin"),
                        object.getString("role"),
                        object.getString("rating"),
                        object.getString("company_id")
                );
                items.add(newLead);
            }

            adapter = new MyAdapter(items);

            if (recyclerView != null) {
                recyclerView.setAdapter(adapter);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}