package com.example.gosia.glucophone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;






public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button przyciskStart = (Button) findViewById(R.id.nowy);
        przyciskStart.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View v) {
                                                 Intent intent = new Intent(getApplicationContext(), DodajPomiar.class);
                                                 startActivity(intent);
                                             }
                                         }
        );

        final Button przyciskWykres = (Button) findViewById(R.id.historia);
        przyciskWykres.setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(getApplicationContext(), Wykres.class);
                                                  startActivity(intent);


                                              }


                                          }
        );

        final Button przyciskWyloguj = (Button) findViewById(R.id.wyloguj);
        przyciskWyloguj.setOnClickListener(new View.OnClickListener() {
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(getApplicationContext(), Loguj.class);
                                                   startActivity(intent);
                                               }
                                           }
        );


    }
}