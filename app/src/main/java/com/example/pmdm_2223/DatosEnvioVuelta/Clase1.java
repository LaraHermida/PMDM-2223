package com.example.pmdm_2223.DatosEnvioVuelta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2223.R;
import com.example.pmdm_2223.taxi.ResultadoDatos;

public class Clase1 extends AppCompatActivity {

    EditText introducirNombre;
    Button bEnviarA2, bSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase1);

        introducirNombre = findViewById(R.id.introducirNombre);
        bEnviarA2 = findViewById(R.id.bEnviarA2);
        bSalir = findViewById(R.id.bSalir);

        bEnviarA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarDatos();
            }
        });
    }

    private void lanzarDatos() {
        Intent intento = new Intent(this, Clase2.class);
        intento.putExtra("NOMBRE", introducirNombre.getText().toString());
    }

}