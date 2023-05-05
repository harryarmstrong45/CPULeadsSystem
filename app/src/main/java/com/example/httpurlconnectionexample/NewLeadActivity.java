package com.example.httpurlconnectionexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewLeadActivity extends AppCompatActivity {

    String url_insert_lead = "http://stul61.csucl.com/CPU/api.php?apicall=insertIntoTable";
    Spinner spinner_source, spinner_status, spinner_type;

    Button button_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lead);

        spinner_source = findViewById(R.id.spinner_source);
        spinner_status = findViewById(R.id.spinner_status);
        spinner_type = findViewById(R.id.spinner_type);

        populateSpinners();

        //button
        button_submit = findViewById(R.id.button_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URLConnectionPostHandler uRLConnectionPostHandler = new URLConnectionPostHandler();
                uRLConnectionPostHandler.setDataDownloadListener(new URLConnectionPostHandler.DataDownloadListener() {
                    @Override
                    public void dataDownloadedSuccessfully(Object data) {
                        // handler result
                        //TODO: Write a check for successful result
                        Toast.makeText(NewLeadActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void dataDownloadFailed() {
                        Toast.makeText(NewLeadActivity.this, R.string.record_not_added, Toast.LENGTH_SHORT).show();
                    }
                });
                uRLConnectionPostHandler.execute(url_insert_lead, generateParameters());
            }
        });
    }

    private void populateSpinners() {
        List<String> sources = new ArrayList<String>();
        sources.add("website");
        sources.add("telephone");
        sources.add("email");

        List<String> status = new ArrayList<String>();
        status.add("new");
        status.add("working");
        status.add("qualified");
        status.add("disqualified");
        status.add("customer");

        List<String> types = new ArrayList<String>();
        types.add("commercial");
        types.add("educational");
        types.add("domestic");

        setSpinnerAdapter(sources, spinner_source);

        setSpinnerAdapter(status, spinner_status);

        setSpinnerAdapter(types, spinner_type);
    }

    private void setSpinnerAdapter(List<String> sources, Spinner spinner_source) {
        ArrayAdapter<String> dataAdapterSources = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sources);
        dataAdapterSources.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_source.setAdapter(dataAdapterSources);
    }

    private String generateParameters() {
        StringBuilder paramString = new StringBuilder();
        paramString.append(getString(R.string.source));
        paramString.append(spinner_source.getItemAtPosition(spinner_source.getSelectedItemPosition()).toString());
        paramString.append(getString(R.string.status));
        paramString.append(spinner_status.getItemAtPosition(spinner_status.getSelectedItemPosition()).toString());
        paramString.append(getString(R.string.typeoflead));
        paramString.append(spinner_type.getItemAtPosition(spinner_type.getSelectedItemPosition()).toString());
        paramString.append(getString(R.string.linkedinprofile_n_a));
        paramString.append(getString(R.string.role_1234));
        return paramString.toString();
    }
}