package com.example.SolfasAPP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPass;
    private Button mButtonLogin;
    private Button mButtonForgetPass;
    private Button mButtonRegister;

    private String email = "";
    private String password = "";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail =  findViewById(R.id.editTextEmail);
        mPass =  findViewById(R.id.editTextPass);
        mButtonLogin = findViewById(R.id.buttonLogin);
        mButtonForgetPass = findViewById(R.id.buttonRecContra);
        mButtonRegister = findViewById(R.id.buttonRegistrar);

        mAuth = FirebaseAuth.getInstance();

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrarUsuario.class);
                startActivity(intent);
                finish();
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getText().toString();
                password = mPass.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                    loginUsuario();

                }else{
                    Toast.makeText(LoginActivity.this, "Debes de rellenar todos los campos", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

        public void loginUsuario(){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "No se ha podido entrar a la cuenta del usuario", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
}
