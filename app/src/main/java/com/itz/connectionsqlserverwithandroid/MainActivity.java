package com.itz.connectionsqlserverwithandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    private Spinner semestres;
    private EditText nc,nombre,apellidos;
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nc = findViewById(R.id.ncontrol);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
       btn_add = findViewById(R.id.btn_agregar);
        semestres = findViewById(R.id.semestre);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.semestres,android.R.layout.simple_spinner_item);
        semestres.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nc.getText().toString().trim().compareTo("") == 0){
                    Toast.makeText(getApplicationContext(),
                            "Escribe el No. de Control", Toast.LENGTH_LONG).show();
                }else if (nombre.getText().toString().trim().compareTo("") == 0){
                    Toast.makeText(getApplicationContext(),
                            "Escribe el Nombre", Toast.LENGTH_LONG).show();
                }else if (apellidos.getText().toString().trim().compareTo("") == 0){
                    Toast.makeText(getApplicationContext(),
                            "Escribe los apellidos", Toast.LENGTH_LONG).show();
                }else if (semestres.getSelectedItem().toString().trim().compareTo("") == 0){
                    Toast.makeText(getApplicationContext(),
                            "Selecciona un semestre", Toast.LENGTH_LONG).show();
                }else {
                    try {
                        Querys.ejecutaIUD("INSERT INTO alumnos(nc,nombre,apellidos,semestre) "
                                +"VALUES ('"+nc.getText()+"','"+nombre.getText()+"','"+apellidos.getText()+"',"
                        +Integer.parseInt(semestres.getSelectedItem().toString())+")");
                        Intent i= new Intent(getApplicationContext(),SecondActivity.class);
                        startActivity(i);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),
                                "Error INSERT:"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }


}
