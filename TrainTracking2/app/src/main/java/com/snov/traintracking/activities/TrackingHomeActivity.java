package com.snov.traintracking.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.snov.traintracking.R;

public class TrackingHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_home);

        Button ShareTrain = (Button)findViewById(R.id.share_train);
        Button ViewTrain = (Button)findViewById(R.id.view_train);

        ShareTrain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(TrackingHomeActivity.this, SharingTrainListActivity.class);
                startActivity(intent);
            }
        });

        ViewTrain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(TrackingHomeActivity.this, TrackingTrainListActivity.class);
                startActivity(intent);
            }
        });


    }
}
