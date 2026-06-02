package com.example.proyectofinal;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Enlazamos los contenedores y pestañas con el diseño XML
        tabLayoutCategorias = findViewById(R.id.tabLayoutCategorias);
        bloqueComida = findViewById(R.id.bloqueComida);
        bloqueBebidas = findViewById(R.id.bloqueBebidas);
        bloqueSnacks = findViewById(R.id.bloqueSnacks);

        // Enlazamos los 4 botones de comida
        btnVerHamburguesa = findViewById(R.id.btnVerHamburguesa);
        btnVerPizza = findViewById(R.id.btnVerPizza);
        btnVerBaguette = findViewById(R.id.btnVerBaguette);
        btnVerCarne = findViewById(R.id.btnVerCarne);

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
