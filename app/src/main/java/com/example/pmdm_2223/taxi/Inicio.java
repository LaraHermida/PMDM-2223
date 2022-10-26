package com.example.pmdm_2223.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.example.pmdm_2223.R;

public class Inicio extends AppCompatActivity {

    EditText fechaSalida, horaSalida, fechaVuelta, horaVuelta, nombreViajero,direccionRecogida,dni;
    ToggleButton bIdaVuelta;
    Button bEnviar;
    Spinner spinnerCiudades;
    String ciudadSeleccionada,resultIdaVuelta="ida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        fechaSalida = findViewById(R.id.fechaSalida);
        horaSalida = findViewById(R.id.horaSalida);
        fechaVuelta = findViewById(R.id.fechaVuelta);
        horaVuelta = findViewById(R.id.horaVuelta);
        nombreViajero = findViewById(R.id.nombreViajero);
        direccionRecogida = findViewById(R.id.direccionRecogida);
        dni = findViewById(R.id.dni);
        bIdaVuelta = (ToggleButton) findViewById(R.id.bIdaVuelta);
        bEnviar = findViewById(R.id.bEnviar);
        spinnerCiudades = (Spinner) findViewById(R.id.spinner_ciudades);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCiudades.setAdapter(adapter);

        fechaVuelta.setVisibility(View.INVISIBLE);
        horaVuelta.setVisibility(View.INVISIBLE);

        bIdaVuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bIdaVuelta.isChecked()){
                    fechaVuelta.setVisibility(View.VISIBLE);
                    horaVuelta.setVisibility(View.VISIBLE);
                    resultIdaVuelta="idaVuelta";

                } else {
                    fechaVuelta.setVisibility(View.INVISIBLE);
                    horaVuelta.setVisibility(View.INVISIBLE);
                    resultIdaVuelta="ida";
                }
            }
        });

        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarDatos();
            }
        });

    }

    private void lanzarDatos(){
        Intent intento = new Intent(this, ResultadoDatos.class);
        intento.putExtra("FECHA_SALIDA", fechaSalida.getText().toString());
        intento.putExtra("HORA_SALIDA", horaSalida.getText().toString());
        intento.putExtra("FECHA_VUELTA", fechaVuelta.getText().toString());
        intento.putExtra("HORA_VUELTA", horaVuelta.getText().toString());
        intento.putExtra("NOMBRE", nombreViajero.getText().toString());
        intento.putExtra("DIRECCION", direccionRecogida.getText().toString());
        intento.putExtra("DNI", dni.getText().toString());
        ciudadSeleccionada = spinnerCiudades.getSelectedItem().toString();
        intento.putExtra("CIUDAD", ciudadSeleccionada);
        intento.putExtra("RESULTADO_IDA_VUELTA", resultIdaVuelta);
        startActivity(intento);
    }
    /*
    private boolean validarDni(){
        String dni1 = String.valueOf(dni.getText());
        if (dni1.isEmpty()){
            Toast.makeText(getApplicationContext(),"Campo dni vacío",Toast.LENGTH_SHORT).show();
            return false;
        }else if(dni1.matches("^[0-9]{8}[A|B|C|D|E|F|G|H|J|K|L|M|N|P|Q|R|S|T|V|W|X|Y|Z]")){
           return true;
        }else{
            Toast.makeText(getApplicationContext(),"Campo dni erronéo",Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private boolean validarFecha(){
        String fechaSalida1 = String.valueOf(fechaSalida.getText());
        if (fechaSalida1.isEmpty()){
            Toast.makeText(getApplicationContext(),"Campo fecha salida vacío",Toast.LENGTH_SHORT).show();
            return false;
        }else if(fechaSalida1.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/](22)")){
            return true;
        }else{
            Toast.makeText(getApplicationContext(),"Campo fecha salida erronéo",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    private boolean validarHora(){
        String horaSalida1 = String.valueOf(horaSalida.getText());
        if (horaSalida1.isEmpty()){
            Toast.makeText(getApplicationContext(),"Campo hora salida vacío",Toast.LENGTH_SHORT).show();
            return false;
        }else if(horaSalida1.matches("^(0?[1-9]|[1][0-9]|[2][0-3])[\\:](0?[1-9]|[10-60])")){
            return true;
        }else{
            Toast.makeText(getApplicationContext(),"Campo hora salida erronéo",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

     */

}