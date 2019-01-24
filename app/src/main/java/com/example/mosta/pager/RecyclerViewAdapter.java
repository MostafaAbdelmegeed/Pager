package com.example.mosta.pager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Patient> mPatients;


    public RecyclerViewAdapter(Context mContext, List<Patient> mPatients) {
        this.mContext = mContext;
        this.mPatients = mPatients;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.patientImageView.setImageResource(mPatients.get(position).getmPatientPic());
        holder.patientNameTextView.setText(mPatients.get(position).getmPatientName());
        holder.connectivity.setImageResource(R.drawable.online_icon);
        if (mPatients.get(position).getmSeverity() == 1) {
            holder.severityTextView.setText("Requires Attention!");
            holder.severityTextView.setTextColor(Color.parseColor("#ffeb3b"));
        } else if (mPatients.get(position).getmSeverity() == 2) {
            /**
             * First pushing a notification
             */
            pushNotification(position);

            /**
             *  Vibration
             */
            vibrate();

            /**
             * Then updating the UI
             */
            holder.severityTextView.setText("URGENT!");
            holder.severityTextView.setTextColor(Color.parseColor("#d50000"));
            holder.urgentIndicator.setVisibility(View.VISIBLE);
        } else {
            holder.severityTextView.setText("Stable");
            holder.severityTextView.setTextColor(Color.parseColor("#00e676"));
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PatientActivity.class);
                intent.putExtra("Name", mPatients.get(position).getmPatientName());
                intent.putExtra("Age", mPatients.get(position).getmAge());
                intent.putExtra("Gender", mPatients.get(position).getmGender());
                intent.putExtra("Weight", mPatients.get(position).getmWeight());
                intent.putExtra("HeartBeat", mPatients.get(position).getmHB());
                intent.putExtra("Picture", mPatients.get(position).getmPatientPic());
                intent.putExtra("BloodPressure", mPatients.get(position).getmBP());
                intent.putExtra("Temperature", mPatients.get(position).getmTemp());
                intent.putExtra("Severity", mPatients.get(position).getmSeverity());
                intent.putExtra("Telephone", mPatients.get(position).getmPhoneNumber());
                intent.putExtra("Address", mPatients.get(position).getmAddress());


                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPatients.size();
    }



    public static class MyViewHolder extends ViewHolder {

        TextView patientNameTextView;
        TextView severityTextView;
        ImageView patientImageView;
        RelativeLayout cardRelativeLayout;
        TextView urgentIndicator;
        CardView cardView;
        ImageView connectivity;


        public MyViewHolder(View itemView) {
            super(itemView);
            patientNameTextView = itemView.findViewById(R.id.patient_name);
            patientImageView = itemView.findViewById(R.id.patient_image);
            severityTextView = itemView.findViewById(R.id.severity);
            cardRelativeLayout = itemView.findViewById(R.id.card_relative_layout);
            urgentIndicator = itemView.findViewById(R.id.urgent_indicator);
            cardView = itemView.findViewById(R.id.card_view);
            connectivity = itemView.findViewById(R.id.connection);
        }
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "URGENT!";
            String description = "A case requires your attention!";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("URGENT!", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = mContext.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void pushNotification(final int position) {
        createNotificationChannel();
        Intent intent = new Intent(mContext, NotificationActivity.class);
        intent.putExtra("Name", mPatients.get(position).getmPatientName());
        intent.putExtra("Age", mPatients.get(position).getmAge());
        intent.putExtra("Gender", mPatients.get(position).getmGender());
        intent.putExtra("Weight", mPatients.get(position).getmWeight());
        intent.putExtra("HeartBeat", mPatients.get(position).getmHB());
        intent.putExtra("Picture", mPatients.get(position).getmPatientPic());
        intent.putExtra("BloodPressure", mPatients.get(position).getmBP());
        intent.putExtra("Temperature", mPatients.get(position).getmTemp());
        intent.putExtra("Severity", mPatients.get(position).getmSeverity());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = TaskStackBuilder.create(mContext)
                // add all of DetailsActivity's parents to the stack,
                // followed by DetailsActivity itself
                .addParentStack(MainActivity.class)
                .addNextIntentWithParentStack(intent)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);//PendingIntent.getActivity(mContext, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, "URGENT!")
                    .setSmallIcon(mPatients.get(position).getmPatientPic())
                    .setContentTitle("URGENT CASE!")
                    .setContentText(mPatients.get(position).getmPatientName() + " requires your immediate attention!!")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setBadgeIconType(mPatients.get(position).getmPatientPic());
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext);
            // notificationId is a unique int for each notification that you must define
            notificationManager.notify(1, mBuilder.build());
        } else {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext)
                    .setSmallIcon(mPatients.get(position).getmPatientPic())
                    .setContentTitle("URGENT CASE!")
                    .setContentText(mPatients.get(position).getmPatientName() + " requires your immediate attention!!")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext);
            // notificationId is a unique int for each notification that you must define
            notificationManager.notify(1, mBuilder.build());
        }
    }
    private void vibrate(){
        Vibrator v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(2000, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }
    }

}
