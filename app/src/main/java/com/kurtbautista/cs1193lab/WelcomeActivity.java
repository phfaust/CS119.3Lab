package com.kurtbautista.cs1193lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView tv = (TextView)findViewById(R.id.welcomeText);
        String name = getIntent().getStringExtra("name");
        String[] bdayArr = getIntent().getStringExtra("bday").split("-");
        String bday = bdayArr[0] + "-" + bdayArr[1];
        String dateToday = "";

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("M-d");
        dateToday = df.format(c.getTime());
        System.out.println(dateToday);

        if(bday.equals(dateToday))
        {
            setTitle("Welcome and happy birthday, " + name);
        }
        else
        {
            setTitle("Welcome, " + name);
        }
    }
}
