package com.kurtbautista.cs1193lab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void clearFields(View v)
    {
        EditText name = (EditText)findViewById(R.id.newNameField);
        EditText email = (EditText)findViewById(R.id.newEmailField);
        EditText password = (EditText)findViewById(R.id.newPasswordField);

        name.setText("");
        email.setText("");
        password.setText("");
    }

    public void submitData(View v)
    {
        SharedPreferences prefs = getSharedPreferences("register_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        EditText one = (EditText)findViewById(R.id.newEmailField);
        EditText two = (EditText)findViewById(R.id.newPasswordField);
        EditText three = (EditText)findViewById(R.id.newNameField);
        String username = one.getText().toString();
        String password = two.getText().toString();
        String name = three.getText().toString();
        if(!(username.equals("") && password.equals("") && name.equals("")))
        {
            editor.putString("username", username);
            editor.putString("password", password);
            editor.putString("name", name);
            editor.apply();
            finish();
        }
        else
        {
            String msg = "All fields needed";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
