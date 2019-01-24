package com.example.mosta.pager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        Intent intent = getIntent();

        String name = intent.getExtras().getString("Name");
        String age = intent.getExtras().getString("Age");
        //String Age= String.valueOf(age);
        //Log.i("**********************",Age);
        int gender = intent.getExtras().getInt("Gender");
        String weight = intent.getExtras().getString("Weight");
       // String Weight = weight.toString();
       // Log.i("**********************",Weight);
        String heartbeat = intent.getExtras().getString("HeartBeat");
       // String Heartbeat = heartbeat.toString();
       // Log.i("**********************",Heartbeat);
        String bloodpressure = intent.getExtras().getString("BloodPressure");
      //  String Bloodpressure = bloodpressure.toString();
     //   Log.i("**********************",Bloodpressure);
        String temperature = intent.getExtras().getString("Temperature");
      //  String Temperature = temperature.toString();
      //  Log.i("**********************",Temperature);
        Integer picture = intent.getExtras().getInt("Picture");
        Integer severity = intent.getExtras().getInt("Severity");

        TextView nameTextView = findViewById(R.id.patient_name_patient_activity);
        TextView ageTextView = findViewById(R.id.patient_age_patient_activity);
        TextView genderTextView = findViewById(R.id.patient_gender_patient_activity);
        TextView weightTextView = findViewById(R.id.patient_weight_patient_activity);
        TextView bpTextView = findViewById(R.id.patient_bp_patient_activity);
        TextView tempTextView = findViewById(R.id.patient_temp_patient_activity);
        TextView pulseTextView = findViewById(R.id.patient_pulse_patient_activity);
        TextView conditionTextView = findViewById(R.id.patient_severity_patient_activity);
        ImageView patientImg= findViewById(R.id.patient_image_patient_activity);
        Button medication = findViewById(R.id.medication);
        medication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotificationActivity.this,MedicationActivity.class));
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
}
