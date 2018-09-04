package com.snov.traintracking.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.snov.traintracking.R;

public class TrackingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);


        Spinner StartStationDropDown = (Spinner) findViewById(R.id.Start_Station_DropDown);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> StartAdapter = ArrayAdapter
                .createFromResource(this, R.array.Start_Station_Array,
                        android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        StartAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        StartStationDropDown.setAdapter(StartAdapter);

        StartStationDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Log.v("item", (String) parent.getItemAtPosition(position));
                Toast.makeText(TrackingActivity.this, "Item "+ (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        Spinner EndStationDropDown = (Spinner) findViewById(R.id.End_Station_DropDown);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> EndAdapter = ArrayAdapter
                .createFromResource(this, R.array.End_Station_Array,
                        android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        EndAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        EndStationDropDown.setAdapter(EndAdapter);

        EndStationDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Log.v("item", (String) parent.getItemAtPosition(position));
                Toast.makeText(TrackingActivity.this, "Item "+ (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
}
