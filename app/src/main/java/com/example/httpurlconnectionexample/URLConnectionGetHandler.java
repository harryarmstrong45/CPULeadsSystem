package com.example.httpurlconnectionexample;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionGetHandler extends AsyncTask<Object, Void, Object> {
    DataDownloadListener dataDownloadListener;

    public void setDataDownloadListener(DataDownloadListener dataDownloadListener) {
        this.dataDownloadListener = dataDownloadListener;
    }

    @Override
    protected Object doInBackground(Object... param) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(param[0].toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String result = null;
            try {
                result = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object results) {
        if (results != null) {
            dataDownloadListener.dataDownloadedSuccessfully(results);
        } else
            dataDownloadListener.dataDownloadFailed();
    }

    public static interface DataDownloadListener {
        void dataDownloadedSuccessfully(Object data);
        void dataDownloadFailed();
    }
}
