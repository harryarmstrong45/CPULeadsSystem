package com.example.httpurlconnectionexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url_api_view = "http://stul66.csucl.com/CPU/api.php?apicall=view";

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewLeadActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onResume() {
        super.onResume();
            ViewLeads();
    }

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

    public void jsonDecoder(String json_string) {
        try {
            json_string = json_string.substring(json_string.indexOf("{"));
            ListView listView = (ListView) findViewById(R.id.listView);

            List<String> items = new ArrayList<>();
            JSONObject root = new JSONObject(json_string);

            JSONArray array = root.getJSONArray("leads");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Lead newLead = new Lead(
                        object.getString("Lead_ID"),
                        object.getString("source"),
                        object.getString("status"),
                        object.getString("type"));
                items.add(newLead.toString());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);

            if (listView != null) {
                listView.setAdapter(adapter);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
