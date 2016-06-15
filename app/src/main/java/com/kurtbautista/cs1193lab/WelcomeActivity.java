package com.kurtbautista.cs1193lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView tv = (TextView)findViewById(R.id.welcomeText);
        setTitle("Welcome, " + getIntent().getStringExtra("name"));
    }
}
