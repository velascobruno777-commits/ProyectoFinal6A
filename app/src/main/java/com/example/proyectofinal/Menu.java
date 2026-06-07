package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class Menu extends AppCompatActivity {

    // Variables de las pestañas y bloques
    private TabLayout tabLayoutCategorias;
    private LinearLayout bloqueComida;
    private LinearLayout bloqueBebidas;
    private LinearLayout bloqueSnacks;

    // Variables para los 4 botones de la comida
    private Button btnVerHamburguesa;
    private Button btnVerPizza;
    private Button btnVerBaguette;
    private Button btnVerCarne;

    private Button btnVerHorchata;
    private Button btnVerRefresco;
    private Button btnVerAguaDia;
    private Button btnVerLimon;

    private Button btnVerGalletas;
    private Button btnVerGomitas;
    private Button btnVerCuernito;
    private Button btnVerFrituras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Enlazamos los contenedores y pestañas con el diseño XML
        tabLayoutCategorias = findViewById(R.id.tabLayoutCategorias);
        bloqueComida = findViewById(R.id.bloqueComida);
        bloqueBebidas = findViewById(R.id.bloqueBebidas);
        bloqueSnacks = findViewById(R.id.bloqueSnacks);

        // Enlazamos los 4 botones de COMIDAA
        btnVerHamburguesa = findViewById(R.id.btnVerHamburguesa);
        btnVerPizza = findViewById(R.id.btnVerPizza);
        btnVerBaguette = findViewById(R.id.btnVerBaguette);
        btnVerCarne = findViewById(R.id.btnVerCarne);

        // Conectamos cada botón con su pantalla
        btnVerHamburguesa.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido1.class);
            startActivity(intent);
        });

        btnVerPizza.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido2.class);
            startActivity(intent);
        });

        btnVerBaguette.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido3.class);
            startActivity(intent);
        });

        btnVerCarne.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido4.class);
            startActivity(intent);
        });


        // Enlazamos los 4 botones de BEBIDAS

        btnVerHorchata = findViewById(R.id.btnVerHorchata);
        btnVerRefresco = findViewById(R.id.btnVerRefresco);
        btnVerAguaDia = findViewById(R.id.btnVerAguaDia);
        btnVerLimon = findViewById(R.id.btnVerLimon);

        btnVerHorchata.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido5.class);
            startActivity(intent);
        });

        btnVerRefresco.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido6.class);
            startActivity(intent);
        });

        btnVerAguaDia.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido7.class);
            startActivity(intent);
        });

        btnVerLimon.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido8.class);
            startActivity(intent);
        });

        // Enlazamos los 4 botones de SNACKS

        btnVerGalletas = findViewById(R.id.btnVerGalletas);
        btnVerGomitas = findViewById(R.id.btnVerGomitas);
        btnVerCuernito = findViewById(R.id.btnVerCuernito);
        btnVerFrituras = findViewById(R.id.btnVerFrituras);

        btnVerGalletas.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido9.class);
            startActivity(intent);
        });

        btnVerGomitas.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido10.class);
            startActivity(intent);
        });

        btnVerCuernito.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido11.class);
            startActivity(intent);
        });

        btnVerFrituras.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, detallepedido12.class);
            startActivity(intent);
        });



        // Para que al abrir el menú se vea primero Comida
        bloqueComida.setVisibility(View.VISIBLE);
        bloqueBebidas.setVisibility(View.GONE);
        bloqueSnacks.setVisibility(View.GONE);

        // Control dinámico de pestañas (Comida, Bebidas, Snacks)
        tabLayoutCategorias.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int posicion = tab.getPosition();

                if (posicion == 0) { // Pestaña: Comida
                    bloqueComida.setVisibility(View.VISIBLE);
                    bloqueBebidas.setVisibility(View.GONE);
                    bloqueSnacks.setVisibility(View.GONE);
                } else if (posicion == 1) { // Pestaña: Bebidas
                    bloqueComida.setVisibility(View.GONE);
                    bloqueBebidas.setVisibility(View.VISIBLE);
                    bloqueSnacks.setVisibility(View.GONE);
                } else if (posicion == 2) { // Pestaña: Snacks
                    bloqueComida.setVisibility(View.GONE);
                    bloqueBebidas.setVisibility(View.GONE);
                    bloqueSnacks.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}