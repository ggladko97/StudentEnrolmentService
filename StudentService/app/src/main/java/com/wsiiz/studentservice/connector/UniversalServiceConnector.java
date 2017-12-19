package com.wsiiz.studentservice.connector;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ggladko97 on 09.12.17.
 */
public class UniversalServiceConnector extends AsyncTask<String, Void, String> {

    private String resultData;
    private String method = "GET";
    private String postData;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        System.out.println("POST EXEC:" + s);
        Log.i("POST EXEC:", s);
        resultData = s;
    }

    @Override
    protected String doInBackground(String... params) {
//        String endpoint = "http://192.168.0.12:8080/hello";//check address ifconfig -> wlan0

        Log.i("QUERY", params[0]);


        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);

            if (postData != null) {
                System.out.println("POST DATA NOT NULL");
                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                writer.write(postData);
                connection.setRequestProperty("Content-Type", "application/json");
                writer.flush();
            }

            int statusCode = connection.getResponseCode();
            StringBuilder result = new StringBuilder();
            if (statusCode == 200) {

                InputStream is = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);

                }
                Log.i("line", result.toString());
                System.out.println("line" + result.toString());
            }
            return result.toString();
        } catch (Exception e) {

        }
        return null;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResultData() {
        System.out.println("RESULT: " + resultData);
        if (resultData == null) {
            return null;
        }
        return resultData;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }
}
