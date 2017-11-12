package com.example.paco.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText nombre;
    EditText dni;
    EditText edad;
    String sexo;
    RadioButton hombre;
    RadioButton mujer;

    public static final String PREFS = "My preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hombre = (RadioButton) findViewById(R.id.rhombre);
        hombre.setOnClickListener(this);
        mujer = (RadioButton) findViewById(R.id.rmujer);
        mujer.setOnClickListener(this);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.rhombre){
            sexo="Hombre";

        }

        if(v.getId()==R.id.rmujer){
            sexo="Mujer";

        }

        if(v.getId()==R.id.button) {
            Intent i = new Intent(this, Main2Activity.class);

            nombre = (EditText) findViewById(R.id.nombretxt);
            dni = (EditText) findViewById(R.id.dnitxt);
            edad = (EditText) findViewById(R.id.edadtxt);

            SharedPreferences preferencias = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putString("nombre", String.valueOf(nombre.getText()));
            editor.putString("dni", String.valueOf(dni.getText()));
            editor.putString("edad", String.valueOf(edad.getText()));
            editor.putString("sexo", sexo );


            editor.commit();
            startActivityForResult(i, 1); }



    }




}
