package com.kurtbautista.cs1193lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View v)
    {
        EditText username = (EditText)findViewById(R.id.usernameField);
        EditText password = (EditText)findViewById(R.id.passwordField);
        CheckBox rememberMe = (CheckBox)findViewById(R.id.rememberMeCheckBox);

        String msg = "Username: " + username.getText().toString() + "\n Password: " + password.getText().toString() + "\n Remember Me?: " + rememberMe.isChecked();

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void newUser(View v)
    {
        Intent i = new Intent(this, com.kurtbautista.cs1193lab.RegisterActivity.class);

    }

}
