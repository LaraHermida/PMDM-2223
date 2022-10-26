package com.example.pmdm_2223.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class ResultadoDatos extends AppCompatActivity {

    TextView textSalidaCiudad, textSalidaFechaS, textSalidaHoraS, textSalidaFechaV, textSalidaHoraV, textSalidaNombre, textSalidaDireccion, textSalidaDni, textFijoVuelta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_datos);

        textSalidaCiudad = findViewById(R.id.textSalidaCiudad);
        textSalidaFechaS = findViewById(R.id.textSalidaFechaS);
        textSalidaHoraS = findViewById(R.id.textSalidaHoraS);
        textSalidaFechaV = findViewById(R.id.textSalidaFechaV);
        textSalidaHoraV = findViewById(R.id.textSalidaHoraV);
        textSalidaNombre = findViewById(R.id.textSalidaNombre);
        textSalidaDireccion = findViewById(R.id.textSalidaDireccion);
        textSalidaDni = findViewById(R.id.textSalidaDni);
        textFijoVuelta = findViewById(R.id.textFijoVuelta);

        Intent i = getIntent();

        textSalidaCiudad.setText(i.getStringExtra("CIUDAD"));
        textSalidaFechaS.setText(i.getStringExtra("FECHA_SALIDA"));
        textSalidaHoraS.setText(i.getStringExtra("HORA_SALIDA"));


        if(i.getStringExtra("RESULTADO_IDA_VUELTA").equalsIgnoreCase("ida")){
            textSalidaFechaV.setVisibility(View.INVISIBLE);
            textSalidaHoraV.setVisibility(View.INVISIBLE);
            textFijoVuelta.setVisibility(View.INVISIBLE);

        }else{
            textSalidaFechaV.setText(i.getStringExtra("FECHA_VUELTA"));
            textSalidaHoraV.setText(i.getStringExtra("HORA_VUELTA"));
        }
        textSalidaFechaV.setText(i.getStringExtra("FECHA_VUELTA"));
        textSalidaHoraV.setText(i.getStringExtra("HORA_VUELTA"));
        textSalidaNombre.setText(i.getStringExtra("NOMBRE"));
        textSalidaDireccion.setText(i.getStringExtra("DIRECCION"));
        textSalidaDni.setText(i.getStringExtra("DNI"));




    }
}