package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Imagen que aparece en el principio de la app movil//

        ImageView imagen = findViewById(R.id.imagenLogo);

        imagen.setImageResource(R.drawable.logo);



        //boton para ir a la pantalla de iniciar sesion//

        Button btniniciar = findViewById(R.id.btniniciar);

        btniniciar.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, InicioActivity.class);

            startActivity(intent);

        });

        //segundo boton para la pantalla de crear una cuenta/
        Button btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, RegistrarCuenta.class);

            startActivity(intent);
    });

    }
}