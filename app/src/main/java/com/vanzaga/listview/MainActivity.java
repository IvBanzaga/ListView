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

    private TextView tv1;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        tv1 = findViewById(R.id.textView);
        lv1 = findViewById(R.id.ListView);

        String nombres [] = {"Juan", "Pedro", "Luis", "Carlos", "Ana", "Maria", "Laura", "Sofia", "Lucia", "Marta"};
        String edades [] = {"20", "25", "30", "35", "40", "45", "50", "55", "60", "65"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_escoger, nombres);
        /*lv1.setAdapter(adapter);*/

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv1.setText("La edad de " + lv1.getItemAtPosition(position) + " es " + edades[position] + " años");
            }
        });
    }
}