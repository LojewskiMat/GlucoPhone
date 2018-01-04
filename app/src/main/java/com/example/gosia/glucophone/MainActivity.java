package com.example.gosia.glucophone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button przyciskStart = findViewById(R.id.nowy);
        final Button przyciskWykres = findViewById(R.id.historia);
        final Button przyciskWyloguj = findViewById(R.id.wyloguj);

        przyciskStart.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View v) {
                                                 Intent intent = new Intent(getApplicationContext(), DodajPomiar.class);
                                                 startActivity(intent);
                                             }
                                         }
        );

        przyciskWykres.setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(getApplicationContext(), Wykres.class);
                                                  startActivity(intent);
                                              }
                                          }
        );

        przyciskWyloguj.setOnClickListener(new View.OnClickListener() {
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(getApplicationContext(), Loguj.class);
                                                   startActivity(intent);
                                               }
                                           }
        );


    }
}