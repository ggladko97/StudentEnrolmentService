package com.wsiiz.studentservice;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CustomSearchActivity extends AppCompatActivity {

    ListView listView;
    String [] mockUnivercities = new String[]{"WSIIZ Rzeszów", "PWR", "PK", "Universytet Rolniczy"};
ll
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_search);

        listView = (ListView) findViewById(R.id.listViewRecent);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(CustomSearchActivity.this,
                android.R.layout.simple_list_item_1,mockUnivercities);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });



    }
}
