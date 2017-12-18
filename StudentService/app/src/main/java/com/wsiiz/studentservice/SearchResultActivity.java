package com.wsiiz.studentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wsiiz.studentservice.adapters.UnivercityCustomAdapter;
import com.wsiiz.studentservice.model.Univercity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {

    private RecyclerView rcView;
    private List<Univercity> universList;
    private UnivercityCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        rcView = (RecyclerView) findViewById(R.id.rcView);

        Intent intent = getIntent();
        universList = (ArrayList<Univercity>) intent.getSerializableExtra("universList");
        Log.i("Re3cieved", String.valueOf(universList));

        adapter = new UnivercityCustomAdapter(universList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
