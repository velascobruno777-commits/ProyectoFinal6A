package com.example.proyectofinal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InicioActivity extends Activity {

    EditText etCorreo, etPassword;
    Button btniniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciosecion);

        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPassword);
        btniniciarSesion = findViewById(R.id.btniniciarSesion);

        btniniciarSesion.setOnClickListener(v -> {

            String correo = etCorreo.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (correo.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
            }

        });
    }
}