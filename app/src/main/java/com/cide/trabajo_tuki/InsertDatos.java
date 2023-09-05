package com.cide.trabajo_tuki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;




public class InsertDatos extends AppCompatActivity {
    Button btnEnviar,btnRegresar;
    EditText btnUsu,btnContraseña,btnFecha_nacimiento,btnDocumento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_datos);

        btnEnviar = findViewById(R.id.btnEnviar);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnUsu = findViewById(R.id.btnUsu);
        btnContraseña = findViewById(R.id.btnContraseña);
        btnFecha_nacimiento = findViewById(R.id.btnFecha_nacimiento);
        btnDocumento = findViewById(R.id.btnDocumento);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Insertar("https://hoteriaturismocielo.000webhostapp.com/insertar.php" + btnUsu.getText().toString() + btnContraseña.getText().toString() + btnFecha_nacimiento.getText().toString() + btnDocumento.getText().toString());

            }
        });
    }
        private void Insertar(String URL) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (!response.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Mensaje: " + response, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(InsertDatos.this, "No se a podido registrar", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(InsertDatos.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String, String>();
                    parametros.put("cedula", btnDocumento.getText().toString());
                    parametros.put("contraseña", btnContraseña.getText().toString());
                    parametros.put("fecha_nacimiento", btnFecha_nacimiento.getText().toString());
                    parametros.put("usuario", btnUsu.getText().toString());
                    return parametros;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);


    }
}
