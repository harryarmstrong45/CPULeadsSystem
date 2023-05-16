package com.example.httpurlconnectionexample;

public class API {

    private static final String URL_CPU = "http://stul61.csucl.com/CPU/api.php?apicall=";
    public static final String VIEW_TABLE = "view";
    public static final String INSERT_IN_ROW = "insertIntoTable";
    public static final String UPDATE_ROW = "updateData";
    public static final String CONVERT_LEAD = "convert_to_lead";

    public static String getApiUrl(String apiCall) {
        return URL_CPU + apiCall;

    }
}