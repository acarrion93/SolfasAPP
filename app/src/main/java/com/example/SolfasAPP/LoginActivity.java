package com.example.SolfasAPP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private Button loguin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email =  findViewById(R.id.editTextEmail);
        email =  findViewById(R.id.editTextPass);
        loguin = findViewById(R.id.buttonLoguin);
    }
}
