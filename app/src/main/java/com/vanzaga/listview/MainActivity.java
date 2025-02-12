package com.vanzaga.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Variables
    private TextView tv1;
    private ListView lv1;

    // Creamos un array de nombres y edades
    private String nombres [] = {"Juan", "Pedro", "Luis", "Carlos", "Ana", "Maria", "Laura", "Sofia", "Lucia", "Marta"};
    private String edades [] = {"20", "25", "30", "35", "40", "45", "50", "55", "60", "65"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Asignar variables a los elementos del layout del diseño de la interfaz
        tv1 = findViewById(R.id.textView);
        lv1 = findViewById(R.id.ListView);

        // Creamos un adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_escoger, nombres);
        lv1.setAdapter(adapter);

        // Creamos el evento para el ListView
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            // Método para mostrar la edad de la persona seleccionada
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv1.setText("La edad de " + lv1.getItemAtPosition(position) + " es " + edades[position] + " años");
            }
        });
    }
}