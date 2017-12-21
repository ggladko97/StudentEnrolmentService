package com.wsiiz.studentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wsiiz.studentservice.R;
import com.wsiiz.studentservice.model.User;


public class MainActivity extends AppCompatActivity {

    TextView tvLogin, tvUserName, tvLikes, tvDislikes;
    Button btnBack,btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Log.i("Incoming intent", intent.toString());

        User incomingUser = (User) intent.getSerializableExtra("user");

        tvLogin = (TextView) findViewById(R.id.txtLogin);
        tvUserName = (TextView) findViewById(R.id.txtUserName);
        tvLikes = (TextView) findViewById(R.id.txtLikes);
        tvDislikes = (TextView) findViewById(R.id.txtDisLikes);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnMenu = (Button) findViewById(R.id.btnMenu);


        tvLogin.setText(incomingUser.getName());
        tvUserName.setText(incomingUser.getName());
        tvLikes.setText(String.valueOf(incomingUser.getLikes()));
        tvDislikes.setText(String.valueOf(incomingUser.getDislikes()));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(in);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, CustomSearchActivity.class);
                startActivity(in);
            }
        });

    }
}
