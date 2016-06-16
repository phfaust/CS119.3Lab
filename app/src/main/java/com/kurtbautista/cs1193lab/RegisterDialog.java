package com.kurtbautista.cs1193lab;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Essel on 6/16/2016.
 */
public class RegisterDialog extends Dialog
{
    private String result;

    public RegisterDialog(Context c)
    {
        super(c);
        setTitle("Register");
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_register);

        Button ok = (Button)findViewById(R.id.confirmNewUserButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
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
                    dismiss();
                }
                else
                {
                    String msg = "All fields needed";
                    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button clear = (Button)findViewById(R.id.clearNewUserFieldsButton);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.newNameField);
                EditText email = (EditText)findViewById(R.id.newEmailField);
                EditText password = (EditText)findViewById(R.id.newPasswordField);

                name.setText("");
                email.setText("");
                password.setText("");
            }
        });

    }
}
