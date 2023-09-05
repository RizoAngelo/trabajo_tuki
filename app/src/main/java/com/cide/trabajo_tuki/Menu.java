package com.cide.trabajo_tuki;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    Button btnregresar,btnselect,btnInsect;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnregresar = findViewById(R.id.btnregresar);
        btnselect = findViewById(R.id.btnselect);
        btnInsect = findViewById(R.id.btnInsect);

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
 /*Pasar entre paginas*/
                startActivity(new Intent(Menu.this,MainActivity.class));

            }
        });
        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Menu.this,SelectDatos.class));

            }
        });
        btnInsect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this,InsertDatos.class));

            }
        });
    }
}