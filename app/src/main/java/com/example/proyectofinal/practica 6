package com.cbtis.plantillabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    EditText editNombre, editApellido, editEdad, editEmail;
    Button btnAgregar;
    ListView lista;

    ArrayList<String> datosUsuarios;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular vistas
        editNombre = findViewById(R.id.editNombre);
        editApellido = findViewById(R.id.editApellido);
        editEdad = findViewById(R.id.editEdad);
        editEmail = findViewById(R.id.editEmail);
        btnAgregar = findViewById(R.id.btnAgregar);
        lista = findViewById(R.id.lista);

        datosUsuarios = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datosUsuarios);
        lista.setAdapter(adapter);

        btnAgregar.setOnClickListener(v -> {
            String nom = editNombre.getText().toString();
            String ape = editApellido.getText().toString();
            String eda = editEdad.getText().toString();
            String ema = editEmail.getText().toString();

            if (!nom.isEmpty() && !ape.isEmpty() && !eda.isEmpty() && !ema.isEmpty()) {
                Toast.makeText(this, "Enviado", Toast.LENGTH_SHORT).show();
                // Crear el Intent para ir a DetalleActivity
                Intent intent = new Intent(MainActivity.this, second.class);

                // Meter los datos en la "maleta" (llave, valor)
                intent.putExtra("p_nombre", nom);
                intent.putExtra("p_apellido", ape);
                intent.putExtra("p_edad", eda);
                intent.putExtra("p_email", ema);

                // Iniciar la nueva actividad
                startActivity(intent);

            } else {
                Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void limpiarCampos() {
        editNombre.setText("");
        editApellido.setText("");
        editEdad.setText("");
        editEmail.setText("");
        editNombre.requestFocus(); // Pone el cursor de nuevo en el nombre
    }
}
