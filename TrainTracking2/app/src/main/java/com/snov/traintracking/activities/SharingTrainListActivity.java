package com.snov.traintracking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.snov.traintracking.R;
import com.snov.traintracking.utilities.Config;

/**
 * Created by Shamalka Navod on 2018-09-05.
 */
public class SharingTrainListActivity extends AppCompatActivity {

    CardView Rajini;
    CardView Manike;
    CardView Kumari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_sharing_list);

        Rajini = (CardView)findViewById(R.id.rajini);
        Manike = (CardView)findViewById(R.id.manike);
        Kumari = (CardView)findViewById(R.id.kumari);

        Rajini.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(SharingTrainListActivity.this, SharingActivity.class);
                startActivity(intent);
                Config.TRAIN_ID="Rajini";
                Config.JSON_PATH="rajarata_rajini";
            }
        });

        Manike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(SharingTrainListActivity.this, SharingActivity.class);
                startActivity(intent);
                Config.TRAIN_ID="Manike";
                Config.JSON_PATH="udarata_manike";
            }
        });

        Kumari.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(SharingTrainListActivity.this, SharingActivity.class);
                startActivity(intent);
                Config.TRAIN_ID="Kumari";
                Config.JSON_PATH="ruhunu_kumari";
            }
        });
    }
}
