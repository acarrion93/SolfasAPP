package com.example.SolfasAPP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrarUsuario extends AppCompatActivity {

    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonRegister;

    // Variables que vamos a registrar

    private String name = "" ;
    private String email = "" ;
    private String password = "" ;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        mEditTextName = findViewById(R.id.editTextNombre);
        mEditTextEmail = findViewById(R.id.editTextEmail);
        mEditTextPassword = findViewById(R.id.editTextPass);
        mButtonRegister = findViewById(R.id.buttonCrear);

        mButtonRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                name = mEditTextName.getText().toString();
                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();

                mAuth = FirebaseAuth.getInstance();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    if(password.length()>=6){
                        registerUser();
                    }else{
                        Toast.makeText(RegistrarUsuario.this, "La contraseña debe de ser mínimo de 6 caracteres", Toast.LENGTH_LONG).show();
                    }

                } else{
                    Toast.makeText(RegistrarUsuario.this, "Debes de completar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });

    }
}
