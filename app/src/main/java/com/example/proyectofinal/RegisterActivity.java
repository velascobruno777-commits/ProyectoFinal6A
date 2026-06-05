package com.example.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RegisterActivity extends Activity {

    EditText etNombre, etCorreoRegistro, etPasswordRegistro, etNumero;
    Button btnCrearCuenta;

    String url = "http://192.168.1.16:5000/usuarios";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNombre = findViewById(R.id.etNombre);
        etCorreoRegistro = findViewById(R.id.etCorreoRegistro);
        etPasswordRegistro = findViewById(R.id.etPasswordRegistro);
        etNumero = findViewById(R.id.etNumero);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

        btnCrearCuenta.setOnClickListener(v -> {

            String nombre = etNombre.getText().toString().trim();
            String correo = etCorreoRegistro.getText().toString().trim();
            String password = etPasswordRegistro.getText().toString().trim();
            String numero = etNumero.getText().toString().trim();

            if (nombre.isEmpty() || correo.isEmpty() || password.isEmpty() || numero.isEmpty()) {
                Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                registrarUsuario(nombre, correo, password);
            }
        });
    }

    private void registrarUsuario(String nombre, String correo, String password) {
        try {
            JSONObject datos = new JSONObject();
            datos.put("nombre", nombre);
            datos.put("correo", correo);
            datos.put("contrasena", password);

            RequestQueue queue = Volley.newRequestQueue(this);

            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    datos,
                    response -> {
                        Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(RegisterActivity.this, InicioActivity.class);
                        startActivity(intent);
                    },
                    error -> {
                        Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show();
                    }
            );

            queue.add(request);

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}