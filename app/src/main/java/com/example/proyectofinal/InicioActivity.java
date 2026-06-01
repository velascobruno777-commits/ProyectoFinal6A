package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class InicioActivity extends AppCompatActivity {

    EditText nombre, contraseña;
    Button iniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciosesion);

        nombre= findViewById(R.id.etNombre);

        contraseña= findViewById(R.id.etcontraseña);

        iniciar= findViewById(R.id.btnCrear);


        //detector del boton al tocar iniciar sesion
        iniciar.setOnClickListener(v -> {


            //aca guarda la info de ususario
            String usuario = nombre.getText().toString();

            String contra = contraseña.getText().toString();


            // (es la IP actual de Flask, y une el usuario
            // y la contraseña)

            String url = "http://10.0.0.14:5000/usuarios/login/"
                    + usuario + "/" + contra;

            //Consultaremos a flask

            StringRequest request = new StringRequest(
                    Request.Method.GET,
                    url,

                    response -> {

                        Toast.makeText(
                                getApplicationContext(),
                                "LOGIN CORRECTO",
                                Toast.LENGTH_SHORT
                        ).show();

                        Intent intent = new Intent(
                                InicioActivity.this,
                                MenuActivity.class
                        );

                        startActivity(intent);

                        finish();
                    },


                    error -> {

                        Toast.makeText(
                                getApplicationContext(),
                                "Usuario incorrecto",
                                Toast.LENGTH_SHORT
                        ).show();
                    }

            );


            //crear cola de volley para mandar la peticion a Flask
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

            queue.add(request);
        });





    }
}
