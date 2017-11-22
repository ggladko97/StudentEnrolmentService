package com.wsiiz.studentservice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private Button btnCheckConn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheckConn = (Button) findViewById(R.id.btnTestConnection);
        tv = (TextView) findViewById(R.id.textView);
        btnCheckConn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, String>() {
                    @Override
                    protected void onPostExecute(String s) {
                        tv.setText("Success: " + s);
                    }

                    @Override
                    protected String doInBackground(String... params) {

                        String endpoint = "http://192.168.0.12:8080/hello";//check address ifconfig -> wlan0

                        Log.i("QUERY", endpoint);


                        try {
                            URL url = new URL(endpoint);
                            URLConnection connection = url.openConnection();

                            InputStream is = connection.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                            StringBuilder result = new StringBuilder();

                            String line;
                            while ((line = reader.readLine()) != null) {
                                result.append(line);

                            }
                            Log.i("line", result.toString());

                            return result.toString();
                        } catch (Exception e) {

                        }
                        return null;
                    }
                }.execute("");

            }
        });


    }
}
