package com.example.gosia.glucophone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Gosia on 10.11.2017.
 */

public class WyborPacjenta extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"Jan Nowak", "Staś Kowalski", "Ala Makota"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wybor_pacjenta);

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(WyborPacjenta.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:

                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                Intent intent = new Intent(getApplicationContext(), Wykres.class);
                startActivity(intent);
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}