package com.example.mosta.pager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    public static List<Patient> patients;
    private static final String TAG = "Main2Activity";
    String data;

    @Override
    protected void onStart() {
        super.onStart();
        data = getIntent().getStringExtra("vitals");
        Log.e(TAG, "Data recieved : " + data);

        patients = new ArrayList<>();
        patients.add(new Patient(R.drawable.asset_0, "Mustafa As'ad", 1, 21, 80, 75, data, 125, "+201028771928", "El Manial / EL Roda"));
        patients.add(new Patient(R.drawable.asset_1, "Ez ElDeen", 1, 21, 80, 50, "39", 130));
        patients.add(new Patient(R.drawable.asset_2, "Mohamed Zaki", 1, 21, 80, 75, "40", 125));
        patients.add(new Patient(R.drawable.asset_3, "Talyah Reda", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient(R.drawable.asset_4, "Bumer Simpson", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient(R.drawable.asset_5, "Tahya Karioka", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient(R.drawable.asset_6, "Raya Skeena", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient(R.drawable.asset_7, "Tant Manar", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient("Youssef El22r3", 1, 21, 80, 75, "37", 125));


        RecyclerView myrv = findViewById(R.id.recyclerview);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, patients);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);
        Log.e(TAG, "Data recieved : " + data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        data = getIntent().getStringExtra("vitals");
        Log.e(TAG, "Data recieved : " + data);

        patients = new ArrayList<>();
        patients.add(new Patient(R.drawable.asset_0, "Mustafa As'ad", 1, 21, 80, 75, data, 125, "+201028771928", "El Manial / EL Roda"));
        patients.add(new Patient(R.drawable.asset_1, "Ez ElDeen", 1, 21, 80, 50, "39", 130));
        patients.add(new Patient(R.drawable.asset_2, "Mohamed Zaki", 1, 21, 80, 75, "40", 125));
        patients.add(new Patient(R.drawable.asset_3, "Talyah Reda", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient(R.drawable.asset_4, "Bumer Simpson", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient(R.drawable.asset_5, "Tahya Karioka", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient(R.drawable.asset_6, "Raya Skeena", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient(R.drawable.asset_7, "Tant Manar", 1, 21, 80, 75, "37", 125));
        patients.add(new Patient("Youssef El22r3", 1, 21, 80, 75, "37", 125));


        RecyclerView myrv = findViewById(R.id.recyclerview);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, patients);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);
    }

}


