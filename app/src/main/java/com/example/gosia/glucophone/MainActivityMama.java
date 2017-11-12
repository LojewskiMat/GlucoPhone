package com.example.gosia.glucophone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Gosia on 10.11.2017.
 */

public class MainActivityMama extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mama);




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

