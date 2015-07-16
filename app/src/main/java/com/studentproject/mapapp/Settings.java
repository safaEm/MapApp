package com.studentproject.mapapp;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Settings extends ActionBarActivity {

    EditText n1, n2, n3, emergency_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);
        n3 = (EditText) findViewById(R.id.n3);
        emergency_message = (EditText) findViewById(R.id.emergency_message);

        n1.setText(sp.getString("number1", null));
        n2.setText(sp.getString("number2", null));
        n3.setText(sp.getString("number3", null));
        emergency_message.setText(sp.getString("emergency_message", null));
    }

    public void done(View view) {
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (n1.length() == 0 || n2.length() == 0 || n3.length() == 0 || emergency_message.length() == 0) {
            Toast.makeText(getApplicationContext(), "Fill the empty", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString("number1", n1.getText().toString());
            editor.putString("number2", n2.getText().toString());
            editor.putString("number3", n3.getText().toString());
            editor.putString("emergency_message", emergency_message.getText().toString());
            editor.apply();
            finish();
        }


    }




}
