package com.itz.connectionsqlserverwithandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = findViewById(R.id.btn);

        Tabla tabla = new Tabla(this,(TableLayout)findViewById(R.id.tabla));
         ArrayList alumnos = new ArrayList();
         try {
             alumnos = Querys.getAll();
             for (int i = 0; i < alumnos.size();i++ ){
                 DatosAlumno d = new DatosAlumno();
                 ArrayList<String> elementos = new ArrayList<String>();
                 elementos.add(d.getNc());
                 elementos.add(d.getNombre());
                 elementos.add(d.getApellidos());
                 elementos.add(d.getSemestre()+"");
                 tabla.addFilaTabla(elementos);
             }
         }catch (SQLException ex){
             Toast.makeText(getApplicationContext(), "Error. "+ex.getLocalizedMessage(),
                     Toast.LENGTH_LONG).show();
         }

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(intent);
             }
         });


    }
}
class  Tabla{
    private TableLayout tabla; // layout donde se pintara la tabla
    private ArrayList<TableRow> filas;
    private Activity actividad;
    private Resources resources;
    private int FILAS,COLUMNAS;

    public Tabla (Activity actividad, TableLayout tabla){
        this.actividad = actividad;
        this.tabla = tabla;
        resources = this.actividad.getResources();
        FILAS = COLUMNAS = 0;
        filas = new ArrayList<TableRow>();
    }


    public void addHeader(int recursocabecera){
        TableRow.LayoutParams layoutCelda;
        TableRow fila = new TableRow(actividad);
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        fila.setLayoutParams(layoutFila);

        String[] arraycabecera = resources.getStringArray(recursocabecera);
        COLUMNAS = arraycabecera.length;

        for (int i=0; i < arraycabecera.length; i++){
            TextView texto = new TextView(actividad);
            layoutCelda = new TableRow.LayoutParams(
                    getAnchoPixelesTexto(arraycabecera[i]),TableRow.LayoutParams.WRAP_CONTENT);
            texto.setText(arraycabecera[i]);
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            texto.setLayoutParams(layoutCelda);

            fila.addView(texto);
        }

        tabla.addView(fila);
        filas.add(fila);
        FILAS++;

    }


    public void addFilaTabla(ArrayList<String> elementos){
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(
                            TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividad);
        fila.setLayoutParams(layoutFila);

        for (int i=0; i < elementos.size(); i++){
            TextView texto = new TextView(actividad);
            texto.setText(String.valueOf(elementos.get(i)));
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            layoutCelda = new TableRow.LayoutParams(
                    getAnchoPixelesTexto(texto.getText().toString()),TableRow.LayoutParams.WRAP_CONTENT);
            texto.setLayoutParams(layoutCelda);

            fila.addView(texto);
        }

        tabla.addView(fila);
        filas.add(fila);
        FILAS++;
    }



    private int getAnchoPixelesTexto(String texto){
        Paint p = new Paint();
        Rect bounds = new Rect();
        p.setTextSize(50);

        p.getTextBounds(texto,0, texto.length(),bounds);
        return bounds.width();
    }



















}
