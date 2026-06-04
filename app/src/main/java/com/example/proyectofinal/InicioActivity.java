package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class InicioActivity extends AppCompatActivity {

    EditText nombre, contraseña;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciosesion);

        nombre = findViewById(R.id.etCorreo);
        contraseña = findViewById(R.id.etPassword);
        iniciar = findViewById(R.id.btniniciar);

        iniciar.setOnClickListener(v -> {

            String usuario = nombre.getText().toString().trim();
            String contra = contraseña.getText().toString().trim();

            if (usuario.isEmpty() || contra.isEmpty()) {
                Toast.makeText(
                        getApplicationContext(),
                        "Llena todos los campos",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            String url = "http://10.89.123.31:5000/usuarios/login/"
                    + nombre.getText().toString()
                    + "/"
                    + contraseña.getText().toString();

            StringRequest request = new StringRequest(
                    Request.Method.GET,
                    url,

                    response -> {

                        Toast.makeText(
                                getApplicationContext(),
                                "LOGIN CORRECTO",
                                Toast.LENGTH_SHORT
                        ).show();

                        Intent intent = new Intent(
                                InicioActivity.this,
                                Menu.class
                        );

                        startActivity(intent);
                        finish();
                    },

                    error -> {

                        Toast.makeText(
                                getApplicationContext(),
                                "Usuario incorrecto o error de conexión",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
            );

            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            queue.add(request);
        });
    }
}