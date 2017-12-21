package com.wsiiz.studentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wsiiz.studentservice.connector.UniversalServiceConnector;
import com.wsiiz.studentservice.model.Credentials;
import com.wsiiz.studentservice.model.User;

import java.util.HashMap;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private User dummyUser;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dummyUser = new User();
        dummyUser.setId(1);
        dummyUser.setName("NAGIBATOR");
        dummyUser.setPassword("12345");
        dummyUser.setLikes(1);
        dummyUser.setDislikes(8);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);


        mPasswordView = (EditText) findViewById(R.id.password);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                attemptLogin();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("user", dummyUser);
                startActivity(intent);
            }
        });
    }

    private void attemptLogin() {
        UniversalServiceConnector connector = new UniversalServiceConnector();
        if (isEmailValid(mEmailView.getText().toString()) && isPasswordValid( mPasswordView.getText().toString())) {
            connector.setMethod("POST");
            HashMap<String, String> map = new HashMap<>();
            map.put("login", mEmailView.getText().toString());
            map.put("password", mPasswordView.getText().toString());
            String data = new Gson().toJson(map);
            Log.i("Post data: ", data);
            connector.setPostData(data);
            connector.execute("http://192.168.0.12:8080/login");

            String resultJson = connector.getResultData();
            Toast.makeText(LoginActivity.this, resultJson, Toast.LENGTH_LONG).show();
            Log.i("Raw data", resultJson);
            Gson gson = new Gson();
            User user = gson.fromJson(resultJson, User.class);
//            Log.i("Recieved user:" , user.getName() + user.getOpinions());
//            if (user.getName().equals("Nothing")) {
//                Toast.makeText(this, "User has not been found", Toast.LENGTH_SHORT).show();
//            }
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Email or password are not valid", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return true;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }



}

