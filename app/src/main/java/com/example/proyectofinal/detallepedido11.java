package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class detallepedido11 extends AppCompatActivity {

    EditText Nombre, Fecha;
    Button btnEnviar;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalledelpedido11);

        Nombre = findViewById(R.id.inputNombre);
        Fecha = findViewById(R.id.inputFecha);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnBack = findViewById(R.id.btnBack);

        // Botón para regresar al menú
        btnBack.setOnClickListener(v -> {
            finish();
        });

        // Botón comprar
        btnEnviar.setOnClickListener(v -> {

            String n = Nombre.getText().toString().trim();
            String f = Fecha.getText().toString().trim();

            if (n.isEmpty()) {
                Nombre.setError("Escribe tu nombre");
            } else if (f.isEmpty()) {
                Fecha.setError("Escribe la fecha");
            } else {

                Intent intent = new Intent(detallepedido11.this, letrero.class);
                startActivity(intent);
            }
        });
    }
}