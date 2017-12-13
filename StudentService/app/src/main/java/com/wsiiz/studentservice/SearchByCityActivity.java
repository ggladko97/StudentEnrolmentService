package com.wsiiz.studentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchByCityActivity extends AppCompatActivity {
    ListView lvCities;
    //get data here from DB
    String[] cities = new String[]{"Rzeszow", "Warsaw", "Wroclaw", "Gdansk", "Lodz", "Lublin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_city);

        lvCities = (ListView) findViewById(R.id.listSearchedCities);
        lvCities.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities));

        lvCities.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchByCityActivity.this, CustomSearchActivity.class);
                intent.putExtra("search", cities[position]);
                startActivity(intent);
            }
        });

    }
}
