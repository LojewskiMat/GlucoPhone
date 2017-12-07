package com.example.gosia.glucophone;

/**
 * Created by Gosia on 20.10.2017.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;


public class DodajPomiar extends Activity implements View.OnClickListener {

    private List<Double> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodaj_pomiar);

        TimePicker zegarek = (TimePicker) findViewById(R.id.timePicker);
        zegarek.setIs24HourView(true);

        Button dodajRecznie = (Button) findViewById(R.id.recznie);
        dodajRecznie.setOnClickListener(this);

        Button synchronizuj = (Button) findViewById(R.id.pobierz);
        synchronizuj.setOnClickListener(this);


        // DBHelper db = new DBHelper(this);
        // List<DodajPytanie> quesList;
        // quesList = db.getAllQuestions();
        // int k = quesList.size();


    }

    @Override
    public void onClick(View v) {


        DBHelper db = new DBHelper(this);
        List<DodajPytanie> quesList;
        quesList = db.getAllQuestions();
        int k = quesList.size();


        DBHelper2 db2 = new DBHelper2(this);
        List<DodajPytanie> quesList2;
        quesList2 = db2.getAllQuestions();
        int k2 = quesList2.size();

        if (v.getId() == R.id.recznie) {

            final EditText nowyPomiar = (EditText) findViewById(R.id.editText);
            String poziomCukru = String.valueOf(nowyPomiar.getText());
            double poziomCukruDouble = Double.parseDouble(nowyPomiar.getText().toString());


            try {

                int godzina, minuta = 0;

                TimePicker zegarek = (TimePicker) findViewById(R.id.timePicker);
                // zegarek.setIs24HourView(true);
                godzina = zegarek.getCurrentHour();
                minuta = zegarek.getCurrentMinute();

                String czas = String.valueOf(new StringBuilder().append(godzina).append(minuta));

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
                String formattedDate = df.format(c.getTime());


                DodajPytanie q5 = new DodajPytanie(formattedDate, czas, poziomCukru);

                CheckBox poJedzeniu = (CheckBox) findViewById(R.id.checkBox);

                if (poJedzeniu.isChecked()) {
                    db2.addQuestion(q5);
                    if(poziomCukruDouble>=140){
                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                        dlgAlert.setMessage("Twój poziom cukru jest za wysoki!");
                        dlgAlert.setTitle("UWAGA!");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                    }
                    if(poziomCukruDouble<=70){
                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                        dlgAlert.setMessage("Twój poziom cukru jest za niski!");
                        dlgAlert.setTitle("UWAGA!");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                    }


                } else {
                    db.addQuestion(q5);
                    if(poziomCukruDouble>=126){
                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                        dlgAlert.setMessage("Twój poziom cukru jest za wysoki!");
                        dlgAlert.setTitle("UWAGA!");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                    }
                    if(poziomCukruDouble<=70){
                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                        dlgAlert.setMessage("Twój poziom cukru jest za niski!");
                        dlgAlert.setTitle("UWAGA!");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                    }


                }


                Toast.makeText(getBaseContext(), "Dodano wynik: " + poziomCukru, Toast.LENGTH_SHORT).show();


            } catch (NullPointerException e) {
                Toast.makeText(getBaseContext(), "Uwaga! Pomiar niezapisany!", Toast.LENGTH_SHORT).show();

            }


        }


        if (v.getId() == R.id.pobierz) {


            Toast.makeText(getBaseContext(), "Nie znaleziono urządzenia", Toast.LENGTH_SHORT).show();

        }
    }



    public List<Double> getList() {
        return list;
    }


}
