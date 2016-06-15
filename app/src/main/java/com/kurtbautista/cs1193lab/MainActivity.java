package com.kurtbautista.cs1193lab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    static String savedUsername = "";
    static String savedPassword = "";
    static String savedName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View v)
    {
        SharedPreferences prefs = getSharedPreferences("register_data", MODE_PRIVATE);
        savedUsername = prefs.getString("username", "");
        savedPassword = prefs.getString("password", "");
        savedName = prefs.getString("name", "");
        EditText username = (EditText)findViewById(R.id.usernameField);
        EditText password = (EditText)findViewById(R.id.passwordField);
        CheckBox rememberMe = (CheckBox)findViewById(R.id.rememberMeCheckBox);

        String msg = "Username: " + username.getText().toString() + "\n Password: " + password.getText().toString() + "\n Remember Me?: " + rememberMe.isChecked();

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        if(username.getText().toString().equals(savedUsername) && password.getText().toString().equals(savedPassword))
        {
            Intent i = new Intent(this, com.kurtbautista.cs1193lab.WelcomeActivity.class);
            i.putExtra("name", savedName);
            startActivity(i);
        }
    }

    public void newUser(View v)
    {
        Intent i = new Intent(this, com.kurtbautista.cs1193lab.RegisterActivity.class);
        startActivity(i);
    }


}
