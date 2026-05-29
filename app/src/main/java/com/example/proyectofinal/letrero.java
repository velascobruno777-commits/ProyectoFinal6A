package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class letrero extends AppCompatActivity {
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letrero);
        TextView pedido = findViewById(R.id.pedido);
        pedido.setText("Pedido realizado");
        regresar = findViewById(R.id.regresar);
        regresar.setOnClickListener(v -> {
            Intent intent = new Intent(letrero.this, sustituir por el menú.class);
            startActivity(intent);
        });
    }
}
