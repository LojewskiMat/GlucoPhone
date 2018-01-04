package com.example.gosia.glucophone;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.String.*;

public class Loguj extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguj);

        final EditText login = findViewById(R.id.login);
        final EditText haslo = findViewById(R.id.password);

        final Button przyciskZaloguj = findViewById(R.id.zaloguj);
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
