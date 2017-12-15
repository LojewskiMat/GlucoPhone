package com.example.gosia.glucophone;

/**
 * Created by Gosia on 20.10.2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by malgosia on 17.04.17.
 */
public class Loguj extends Activity{

    //komentarz testowy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguj);

        final EditText login = (EditText) findViewById(R.id.nazwa);
        final EditText haslo = (EditText) findViewById(R.id.editText2);


        final Button przyciskZaloguj = (Button) findViewById(R.id.zaloguj);
        przyciskZaloguj.setOnClickListener(new View.OnClickListener() {
                                               public void onClick(View v) {

                                                   String mLogin = String.valueOf(login.getText());
                                                   String mHaslo = String.valueOf(haslo.getText());

                                                   if (mLogin.equals("admin") && mHaslo.equals("admin")) {

                                                       Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                       startActivity(intent);
                                                   } else {

                                                       if (mLogin.equals("mama") && mHaslo.equals("mama")) {

                                                           Intent intent = new Intent(getApplicationContext(), MainActivityMama.class);
                                                           startActivity(intent);
                                                       } else {

                                                           if (mLogin.equals("doktor") && mHaslo.equals("doktor")) {

                                                               Intent intent = new Intent(getApplicationContext(), MainActivityDoktor.class);
                                                               startActivity(intent);
                                                           } else {
                                                               Toast.makeText(getBaseContext(), "Niepoprawny login lub hasło", Toast.LENGTH_SHORT).show();
                                                           }
                                                       }
                                                   }
                                               }
                                           }
        );




    }

}
