package com.example.SolfasAPP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPass;
    private Button mButtonLogin;
    private Button mButtonForgetPass;
    private Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail =  findViewById(R.id.editTextEmail);
        mPass =  findViewById(R.id.editTextPass);
        mButtonLogin = findViewById(R.id.buttonLogin);
        mButtonForgetPass = findViewById(R.id.buttonRecContra);
        mButtonRegister = findViewById(R.id.buttonRegistrar);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrarUsuario.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
