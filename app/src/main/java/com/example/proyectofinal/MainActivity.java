package com.example.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btniniciar, btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btniniciar = findViewById(R.id.btniniciar);
        btnCrear = findViewById(R.id.btnCrear);

        btniniciar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InicioActivity.class);
            startActivity(intent);
        });

        btnCrear.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}