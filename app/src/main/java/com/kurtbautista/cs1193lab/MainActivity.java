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
        //SharedPre
    }

    public void showToast(View v)
    {
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
        startActivityForResult(i, 0);
    }

    protected void onActivityResult(int request, int response, Intent data)
    {
        switch(request)
        {
            case 0:
                switch(response)
                {
                    case 1:
                        savedUsername = data.getStringExtra("username");
                        savedPassword = data.getStringExtra("password");
                        savedName = data.getStringExtra("name");
                        System.out.println(savedName + savedUsername + savedPassword);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

}
 //tangnamu
