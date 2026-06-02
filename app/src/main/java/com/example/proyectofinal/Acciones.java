package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Acciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Imagen que aparece al inicio de la app
        ImageView imagen = findViewById(R.id.imagenLogo);
        imagen.setImageResource(R.drawable.logo);

        // Botón para ir a la pantalla de iniciar sesión
        Button btnIniciar = findViewById(R.id.btniniciar);

        btnIniciar.setOnClickListener(v -> {
            Intent intent = new Intent(Acciones.this, InicioActivity.class);
            startActivity(intent);
        });

        // Botón para ir a la pantalla de crear cuenta
        Button btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(v -> {
            Intent intent = new Intent(Acciones.this, RegistrarCuenta.class);
            startActivity(intent);
        });
    }
}