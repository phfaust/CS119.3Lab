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
        Intent i = new Intent();
        Bundle data = new Bundle();
        String username = ((EditText)findViewById(R.id.newEmailField)).getText().toString();
        String password = ((EditText)findViewById(R.id.newPasswordField)).getText().toString();
        data.putString("username", username);
        data.putString("password", password);
        finish();
    }
}
