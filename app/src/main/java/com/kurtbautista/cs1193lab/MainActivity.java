package com.kurtbautista.cs1193lab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;
    String savedUsername;
    String savedPassword;
    String savedName;
    String savedBirthday;
    boolean savedRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {
            prefs = getSharedPreferences("register_data", MODE_PRIVATE);
            savedUsername = prefs.getString("username", "");
            savedPassword = prefs.getString("password", "");
            savedName = prefs.getString("name", "");
            savedBirthday = prefs.getString("bday", "");
            savedRememberMe = prefs.getBoolean("remember", false);
        }
        catch(NullPointerException e)
        {
            savedUsername = "";
            savedPassword = "";
            savedName = "";
            savedBirthday = "";
            savedRememberMe = false;
        }

        if(savedUsername.equals("") && savedPassword.equals(""))
        {
            RegisterDialog rd = new RegisterDialog(this);
            rd.show();
        }
        else if(savedRememberMe)
        {
            EditText username = (EditText)findViewById(R.id.usernameField);
            EditText password = (EditText)findViewById(R.id.passwordField);
            CheckBox remember = (CheckBox)findViewById(R.id.rememberMeCheckBox);
            username.setText(savedUsername);
            password.setText(savedPassword);
            remember.setChecked(true);
        }
    }

    public void showToast(View v)
    {
        String msg = "";
        prefs = getSharedPreferences("register_data", MODE_PRIVATE);
        savedUsername = prefs.getString("username", "");
        savedPassword = prefs.getString("password", "");
        savedName = prefs.getString("name", "");
        savedBirthday = prefs.getString("bday", "");
        EditText username = (EditText)findViewById(R.id.usernameField);
        EditText password = (EditText)findViewById(R.id.passwordField);
        CheckBox rememberMe = (CheckBox)findViewById(R.id.rememberMeCheckBox);

        if(savedUsername.equals("") && savedPassword.equals(""))
        {
            msg = "No user";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        else if(username.getText().toString().equals(savedUsername) && password.getText().toString().equals(savedPassword))
        {
            Intent i = new Intent(this, com.kurtbautista.cs1193lab.WelcomeActivity.class);
            i.putExtra("name", savedName);
            i.putExtra("bday", savedBirthday);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("remember", rememberMe.isChecked());
            editor.apply();
            startActivity(i);
        }
        else
        {
            msg = "Invalid credentials";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public void newUser(View v)
    {
        RegisterDialog rd = new RegisterDialog(this);
        rd.show();
    }


}
