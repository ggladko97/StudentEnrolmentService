package com.wsiiz.studentservice;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wsiiz.studentservice.model.Univercity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CustomSearchActivity extends AppCompatActivity {

    ListView listView;
    String [] mockUnivercities = new String[]{"WSIIZ Rzeszów", "PWR", "PK", "Universytet Rolniczy"};
    private List<Univercity> sendUniversList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_search);
        sendUniversList = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listViewRecent);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(CustomSearchActivity.this,
                android.R.layout.simple_list_item_1,mockUnivercities);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            //put mock data
            Univercity univer = new Univercity();
            univer.setId(0);
            univer.setLocalization("Rzeszow");
            univer.setTitle(mockUnivercities[position]);
            univer.setOpinionss(new HashSet<>(1));

            sendUniversList.addAll(Arrays.asList(univer));
            Log.i("Sended list", String.valueOf(sendUniversList));

            Intent intent = new Intent(CustomSearchActivity.this, SearchResultActivity.class);
            intent.putExtra("universList", (ArrayList<Univercity>) sendUniversList);

            startActivity(intent);
        });



    }
}
