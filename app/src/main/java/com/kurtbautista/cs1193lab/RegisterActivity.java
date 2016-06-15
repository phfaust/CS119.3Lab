package com.kurtbautista.cs1193lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        EditText one = (EditText)findViewById(R.id.newEmailField);
        EditText two = (EditText)findViewById(R.id.newPasswordField);
        EditText three = (EditText)findViewById(R.id.newNameField);
        String username = one.getText().toString();
        String password = two.getText().toString();
        String name = three.getText().toString();
        Intent data = new Intent();
        data.putExtra("username", username);
        data.putExtra("password", password);
        data.putExtra("name", name);
        setResult(1, data);
        finish();
    }
}
