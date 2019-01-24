package com.example.mosta.pager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.mosta.pager.MainActivity.messages;

public class PatientActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_patient);

        TextView nameTextView = findViewById(R.id.patient_name_patient_activity);
        TextView ageTextView = findViewById(R.id.patient_age_patient_activity);
        TextView genderTextView = findViewById(R.id.patient_gender_patient_activity);
        TextView weightTextView = findViewById(R.id.patient_weight_patient_activity);
        TextView bpTextView = findViewById(R.id.patient_bp_patient_activity);
        TextView tempTextView = findViewById(R.id.patient_temp_patient_activity);
        TextView pulseTextView = findViewById(R.id.patient_pulse_patient_activity);
        TextView conditionTextView = findViewById(R.id.patient_severity_patient_activity);
        ImageView patientImg= findViewById(R.id.patient_image_patient_activity);
        TextView patientTelephone = findViewById(R.id.patient_telephone_number);
        TextView patientAddress = findViewById(R.id.patient_address);
        Button refreshButton = findViewById(R.id.refresh);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("Name");

        String age = intent.getExtras().getString("Age");

        int gender = intent.getExtras().getInt("Gender");

        String weight = intent.getExtras().getString("Weight");

        String heartbeat = intent.getExtras().getString("HeartBeat");

        String bloodpressure = intent.getExtras().getString("BloodPressure");

        String temperature = intent.getExtras().getString("Temperature");
        Log.i("PatientActivity","Temperature: " + temperature);

        Integer picture = intent.getExtras().getInt("Picture");

        Integer severity = intent.getExtras().getInt("Severity");

        String phoneNumber = intent.getExtras().getString("Telephone");

        String address = intent.getExtras().getString("Address");

        refreshButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               refresh();

            }
        });


        Button medication = findViewById(R.id.medication);
        medication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PatientActivity.this,MedicationActivity.class));
            }
        });
        nameTextView.setText(name);
        ageTextView.setText(String.valueOf(age));
        if (gender == 1) {
            genderTextView.setText("Male");
        } else {
            genderTextView.setText("Female");
        }
        weightTextView.setText(weight);
        bpTextView.setText(bloodpressure);
        tempTextView.setText(temperature);
        pulseTextView.setText(heartbeat);
        Log.e("PatientActivity","Data passed = "+ phoneNumber);
        patientTelephone.setText(phoneNumber);
        patientAddress.setText(address);

        if (severity==0){
            conditionTextView.setText("Stable");
        } else if (severity == 1){
            conditionTextView.setText("Unstable!");
            conditionTextView.setTextColor(Color.parseColor("#d50000"));
        } else {
            conditionTextView.setText("URGENT!");
            conditionTextView.setTextColor(Color.parseColor("#d50000"));
        }
        patientImg.setImageResource(picture);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("PatientActivity","Temperature: " + messages.toString());
        TextView tempTextView = findViewById(R.id.patient_temp_patient_activity);
        tempTextView.setText(messages.toString());
    }

    private void refresh(){onRestart();}

}

/**
 * Try making a parallel thread that updates the UI
 */
