package com.example.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
                Toast.makeText(InicioActivity.this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
            } else {

                String url = "http://192.168.20.63:5000/usuarios/login/"
                        + Uri.encode(correo) + "/"
                        + Uri.encode(password);

                StringRequest request = new StringRequest(Request.Method.GET, url,
                        response -> {

                            Toast.makeText(InicioActivity.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(InicioActivity.this, Menu.class);
                            startActivity(intent);
                            finish();
                            },
                            error -> {
                                Toast.makeText(InicioActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                            });

                            RequestQueue queue = Volley.newRequestQueue(InicioActivity.this);
                            queue.add(request);
                        }
                });
            }

        }




