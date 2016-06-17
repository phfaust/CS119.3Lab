package com.kurtbautista.cs1193lab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Essel on 6/16/2016.
 */
public class RegisterDialog extends Dialog
{
    private String result;
    private static SharedPreferences prefs;
    public RegisterDialog(Context c)
    {
        super(c);
        setTitle("Register");
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Are you sure you want to cancel?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_register);

        Button ok = (Button)findViewById(R.id.confirmNewUserButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs = getContext().getSharedPreferences("register_data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                EditText one = (EditText)findViewById(R.id.newEmailField);
                EditText two = (EditText)findViewById(R.id.newPasswordField);
                EditText three = (EditText)findViewById(R.id.newNameField);
                DatePicker four = (DatePicker)findViewById(R.id.birthdayDatePicker);
                String username = one.getText().toString();
                String password = two.getText().toString();
                String name = three.getText().toString();
                int day = four.getDayOfMonth();
                int month = four.getMonth() + 1;
                int year = four.getYear();
                String bday = Integer.toString(month) + "-" + Integer.toString(day) + "-" + Integer.toString(year);
                System.out.println(bday);
                if(!(username.equals("") && password.equals("") && name.equals("")))
                {
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.putString("name", name);
                    editor.putString("bday", bday);
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
