package com.example.httpurlconnectionexample;

public class API {

    private static final String URL_CPU = "http://stul61.csucl.com/CPU/api.php?apicall="; //String constant for main URL
    public static final String VIEW_TABLE = "view"; // String constant for vewing the table API function
    public static final String INSERT_IN_ROW = "insertIntoTable"; // String constant for insert API function
    public static final String UPDATE_ROW = "updateData"; // String constant for updating table row API function
    public static final String CONVERT_LEAD = "convert_to_lead"; // String constant for convert API function

    /**
     *
     * @param apiCall The API function being called
     * @return Full API URL
     */
    public static String getApiUrl(String apiCall) {
        return URL_CPU + apiCall;
    }
}