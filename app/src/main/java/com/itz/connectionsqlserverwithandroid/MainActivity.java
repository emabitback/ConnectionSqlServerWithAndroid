package com.itz.connectionsqlserverwithandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner semestres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        semestres = findViewById(R.id.semestre);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.semestres,android.R.layout.simple_spinner_item);
        semestres.setAdapter(adapter);


    }
}
