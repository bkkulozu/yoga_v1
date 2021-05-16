package com.example.kulozubeste;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import Adapter.featuresListAdapter;
import Models.featuresListModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationResultDisplayActivity extends AppCompatActivity {
    TextView tvResult;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_result_display);

        tvResult = findViewById(R.id.tvResult);

        // Look up the notification manager service
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Cancel the notification that we started
        Intent intent = getIntent();
        int notificationId = intent.getIntExtra("notificationID",0);
        String bookName = intent.getStringExtra("bookname");
        mNotificationManager.cancel(notificationId);

        tvResult.setText("Taken from notification \n"+bookName);

    }
}






