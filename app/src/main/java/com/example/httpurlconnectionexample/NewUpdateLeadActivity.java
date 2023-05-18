package com.example.httpurlconnectionexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 Activity for creating or updating a Lead.
 */
public class NewUpdateLeadActivity extends AppCompatActivity {

    private final String url_insert_lead = "http://stul61.csucl.com/CPU/api.php?apicall=insertIntoTable";
    private Spinner spinner_source, spinner_status, spinner_type, spinner_role, spinner_rating;
    private EditText linkedin, reason_disqualified;
    private Lead lead;
    private String API_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lead);

        //Initialise the views
        spinner_source = findViewById(R.id.spinner_source);
        spinner_status = findViewById(R.id.spinner_status);
        spinner_type = findViewById(R.id.spinner_type);
        spinner_rating = findViewById(R.id.spinner_rating);
        spinner_role = findViewById(R.id.spinner_role);
        Button button_submit = findViewById(R.id.button_submit);
        linkedin = findViewById(R.id.editText_linkedIn);
        reason_disqualified = findViewById(R.id.editText_ReasonDis);

        //Check if intent exists
        Intent intent = getIntent();
        if(intent == null) {
            finish();
            return;
        }

        if (intent.hasExtra("selected_lead")) {
            // Updating an existing lead
            lead = (Lead) intent.getSerializableExtra("selected_lead");
            setTitle("Update Lead");
            button_submit.setText("Update");
            if (lead == null) {
                finish();
                return;
            }
            API_URL = API.getApiUrl(API.UPDATE_ROW);
        } else {
            // Creating a new lead
            setTitle("Add Lead");
            button_submit.setText("Add");
            lead = new Lead();
            API_URL = API.getApiUrl(API.INSERT_IN_ROW);
        }


        populateSpinners();

        //Set onclick listner
        button_submit.setOnClickListener(v -> {
            setUpdateLead();
            URLConnectionPostHandler uRLConnectionPostHandler = new URLConnectionPostHandler();
            uRLConnectionPostHandler.setDataDownloadListener(new URLConnectionPostHandler.DataDownloadListener() {
                @Override
                public void dataDownloadedSuccessfully(Object data) {
                    // Handles successful results
                    Toast.makeText(NewUpdateLeadActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void dataDownloadFailed() {
                    // Handles unsuccessful results
                    Toast.makeText(NewUpdateLeadActivity.this, R.string.record_not_added, Toast.LENGTH_SHORT).show();
                }
            });
            uRLConnectionPostHandler.execute(API_URL, generateParameters(lead));

            setResult(Activity.RESULT_OK);
            finish();
        });
    }

    private void setUpdateLead() {
        String updatedSource = spinner_source.getItemAtPosition(spinner_source.getSelectedItemPosition()).toString();
        String updatedStatus = spinner_status.getItemAtPosition(spinner_status.getSelectedItemPosition()).toString();
        String updatedReason = reason_disqualified.getText().toString();
        String updatedType = spinner_type.getItemAtPosition(spinner_type.getSelectedItemPosition()).toString();
        String updatedLinkedIn = linkedin.getText().toString();
        String updatedRole = spinner_role.getItemAtPosition(spinner_role.getSelectedItemPosition()).toString();
        String updatedRating = spinner_rating.getItemAtPosition(spinner_rating.getSelectedItemPosition()).toString();
        Log.d("ROLE", updatedRole);
        lead.setSource(updatedSource);
        lead.setStatus(updatedStatus);
        lead.setReason_disqualified(updatedReason);
        lead.setType(updatedType);
        lead.setLinkedin(updatedLinkedIn);
        lead.setRole(updatedRole);
        lead.setRating(updatedRating);
    }

    private void populateSpinners() {
        linkedin.setText(lead.getLinkedin());
        reason_disqualified.setText(lead.getReason_disqualified());

        setSpinnerAdapter(lead.getSources(), spinner_source);
        setSpinnerAdapter(lead.getStatuses(), spinner_status);
        setSpinnerAdapter(lead.getTypes(), spinner_type);
        setSpinnerAdapter(lead.getRoles(), spinner_role);
        setSpinnerAdapter(lead.getRatings(), spinner_rating);

        // Set selection of spinners on Activity
        spinner_source.setSelection(lead.getSources().indexOf(lead.getSource()));
        spinner_status.setSelection(lead.getStatuses().indexOf(lead.getStatus()));
        spinner_type.setSelection(lead.getTypes().indexOf(lead.getType()));
        spinner_role.setSelection(lead.getRoles().indexOf(lead.getRole()));
        spinner_rating.setSelection(lead.getRatings().indexOf(lead.getRating()));
    }

    private void setSpinnerAdapter(List<String> sources, Spinner spinner_source) {
        ArrayAdapter<String> dataAdapterSources = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sources);
        dataAdapterSources.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_source.setAdapter(dataAdapterSources);
    }
    /**
     Generates the parameters string for the API request.
     @param inputLead The lead object containing the data to be sent.
     @return The generated parameters string.
     */
    private String generateParameters(Lead inputLead) {
        StringBuilder paramString = new StringBuilder();
        paramString.append("Lead_ID=");
        paramString.append(inputLead.getId());
        paramString.append("&source=");
        paramString.append(inputLead.getSource());
        paramString.append("&status=");
        paramString.append(inputLead.getStatus());
        paramString.append("&reason_disqualified");
        paramString.append(inputLead.getReason_disqualified());
        paramString.append("&type=");
        paramString.append(inputLead.getType());
        paramString.append("&role=");
        paramString.append(inputLead.getRole());
        paramString.append("&linkedin=");
        paramString.append(inputLead.getLinkedin());
        paramString.append("&rating=");
        paramString.append(inputLead.getRating());
        Log.d("PARAMETER", paramString.toString());
        return paramString.toString();
    }
}