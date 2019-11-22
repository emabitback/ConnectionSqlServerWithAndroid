package com.itz.connectionsqlserverwithandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = findViewById(R.id.btn);


    }
}
class  Tabla{
    private TableLayout tabla; // layout donde se pintara la tabla
    private ArrayList<TableRow> filas;
    private Activity actividad;
}
