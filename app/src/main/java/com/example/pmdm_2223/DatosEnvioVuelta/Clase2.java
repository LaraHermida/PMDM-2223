package com.example.pmdm_2223.DatosEnvioVuelta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class Clase2 extends AppCompatActivity {

    TextView nombreRecibido;
    EditText introducirNombre2;
    Button bEnviarA3, bVolverA1, bVolverBlanco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase2);

        nombreRecibido = findViewById(R.id.nombreRecibido);
        introducirNombre2 = findViewById(R.id.introducirNombre2);
        bEnviarA3 = findViewById(R.id.bEnviarA3);
        bVolverA1 = findViewById(R.id.bVolverA1);
        bVolverBlanco = findViewById(R.id.bVolverBlanco);

        Intent i = getIntent();
        nombreRecibido.setText(i.getStringExtra("NOMBRE"));
    }
}