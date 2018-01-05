package com.example.gosia.glucophone;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gosia.glucophone.adapter.PomiaryHolderArrayAdapter;
import com.example.gosia.glucophone.adapter.RecyclerViewAdapter;
import com.example.gosia.glucophone.models.Pomiar;
import com.example.gosia.glucophone.retrofit.BaseRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.gosia.glucophone.R.layout.wybor_pacjenta;

/**
 * Created by Gosia on 10.11.2017.
 */

public class WyborPacjenta extends Activity implements AdapterView.OnItemSelectedListener {

    private List<Pomiar> pomiaryList;
    private ProgressDialog progressDialog;
    private ArrayAdapter adapter;
    private BaseRetrofit baseRetrofit;
    private RecyclerViewAdapter recyclerViewAdapter;

    private ListView listView;
    private Spinner spinner;
    private static final String[] paths = {"Jan Nowak", "Staś Kowalski", "Ala Makota"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(wybor_pacjenta);
        prepareRestApi();

        listView = findViewById(R.id.bla);
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(WyborPacjenta.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        prepareListAdapter();


    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                downloadPomiary();
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

    private void prepareListAdapter() {
        pomiaryList = new ArrayList<>();

        adapter = new PomiaryHolderArrayAdapter(getApplicationContext(), pomiaryList);
        listView.setAdapter(adapter);
    }

    private void downloadPomiary() {
        showProgressDialog();
        clearList();
        updateListWithoutRxJava();
    }

    private void prepareRestApi() {
        baseRetrofit = new BaseRetrofit();
    }

    private void updateListWithoutRxJava() {
        Call<List<Pomiar>> allPeople = baseRetrofit.getPomiarApi().getAllPomiar();
        allPeople.enqueue(new Callback<List<Pomiar>>() {
            @Override
            public void onResponse(Call<List<Pomiar>> call, Response<List<Pomiar>> response) {
                if (response.isSuccessful()) {
                    pomiaryList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(WyborPacjenta.this, "Restaurant count : " + pomiaryList.size(), Toast.LENGTH_SHORT).show();
                }
                hideProgressDialog();
            }

            @Override
            public void onFailure(Call<List<Pomiar>> call, Throwable t) {
                Toast.makeText(WyborPacjenta.this, "Ojoj\n" + t.getMessage(), Toast.LENGTH_SHORT).show();
                hideProgressDialog();
            }
        });
    }


    private void hideProgressDialog() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Getting informations...");
        progressDialog.show();
    }

    private void clearList() {
        pomiaryList.clear();
        adapter.notifyDataSetChanged();
        recyclerViewAdapter.notifyDataSetChanged();
    }

}