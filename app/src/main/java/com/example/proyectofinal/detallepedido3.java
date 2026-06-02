package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class detallepedido3 extends AppCompatActivity {

    EditText Nombre, Fecha;
    Button btnEnviar;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalledelpedido3);

        Nombre = findViewById(R.id.inputNombre);
        Fecha = findViewById(R.id.inputFecha);
        btnEnviar = findViewById(R.id.button);
        btnBack = findViewById(R.id.button);

        btnEnviar.setOnClickListener(v -> {

            String n = Nombre.getText().toString();
            String f = Fecha.getText().toString();

            if(n.isEmpty()){
                Nombre.setError("Escribe tu nombre");
            } else if(f.isEmpty()){
                Fecha.setError("Escribe la fecha");
            } else {

                Toast.makeText(this, "Enviando datos...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(detallepedido3.this, letrero.class);
                intent.putExtra("nombre", n);
                intent.putExtra("fecha", f);

                startActivity(intent);
            }
        });
    }

    private void startActivity(Intent intent) {
    }
}
