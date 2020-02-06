package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private Button loguin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.editTextEmail);
        email = (EditText) findViewById(R.id.editTextPass);
        loguin = (Button) findViewById(R.id.buttonLoguin);
    }
}
