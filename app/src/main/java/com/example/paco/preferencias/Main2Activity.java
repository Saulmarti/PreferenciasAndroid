package com.example.paco.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    public static final String PREFS = "My preferences";
    TextView nombretxt;
    TextView dnitxt;
    TextView edadtxt;
    TextView sexotxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombretxt = (TextView) findViewById(R.id.nombretx);
        dnitxt = (TextView) findViewById(R.id.dnitx);
        edadtxt = (TextView) findViewById(R.id.edadtx);
        sexotxt = (TextView) findViewById(R.id.sexotx);


        SharedPreferences preferencias = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
        String nombre = preferencias.getString("nombre","");
        String dni = preferencias.getString("dni","");
        String edad = preferencias.getString("edad","");
        String sexo = preferencias.getString("sexo","");


        nombretxt.setText(nombre);
        dnitxt.setText(dni);
        edadtxt.setText(edad);
        sexotxt.setText(sexo);

    }
}
