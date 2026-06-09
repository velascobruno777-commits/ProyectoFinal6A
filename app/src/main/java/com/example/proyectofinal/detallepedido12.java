package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class detallepedido12 extends AppCompatActivity {

    EditText Nombre, Fecha;
    Button btnEnviar;
    ImageButton btnBack;

    String url = "http://192.168.20.63:5000/pedidos";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalledelpedido12);

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
                guardarPedido(n, f);
            }
        });
    }

    private void guardarPedido(String usuario, String fecha) {

        try {
            JSONObject datos = new JSONObject();

            datos.put("usuario", usuario);
            datos.put("nombre_producto", "Frituras");
            datos.put("fecha", fecha);
            datos.put("precio", 25);

            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    datos,
                    response -> {
                        Toast.makeText(detallepedido12.this, "Pedido guardado", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(detallepedido12.this, letrero.class);
                        startActivity(intent);
                    },
                    error -> {
                        Toast.makeText(detallepedido12.this, "Error al guardar pedido", Toast.LENGTH_SHORT).show();
                    }
            );

            RequestQueue queue = Volley.newRequestQueue(detallepedido12.this);
            queue.add(request);

        } catch (Exception e) {
            Toast.makeText(detallepedido12.this, "Error en los datos", Toast.LENGTH_SHORT).show();
        }
    }
}