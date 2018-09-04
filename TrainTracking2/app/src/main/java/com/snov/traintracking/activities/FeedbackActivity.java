package com.snov.traintracking.activities;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.snov.traintracking.R;
import com.snov.traintracking.adapters.CustomListView;
import com.snov.traintracking.utilities.Constants;
import com.snov.traintracking.utilities.JsonConfig;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedbackActivity extends AppCompatActivity {

    String[] name;
    String[] StartStation;
    String[] EndStation;
    String[] time;
    String[] type;
    ListView listView;
    BufferedInputStream bis;
    String line = null;
    String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        listView = (ListView)findViewById(R.id.TrainsList);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();



        CustomListView customListView = new CustomListView(this, name, StartStation, EndStation, time, type);
        listView.setAdapter(customListView);
    }

    private void collectData(){
        //connection
        try {
            URL url = new URL(Constants.SERVER_URL+"?"+ JsonConfig.GET_TRAINS);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            bis = new BufferedInputStream(con.getInputStream());

            //Toast.makeText(FeedbackActivity.this, "Connection Established.!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            //Toast.makeText(FeedbackActivity.this, "Connection Failed.!", Toast.LENGTH_SHORT).show();
        }

        //content
        try {
            BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(bis)));
            StringBuilder stringBuilder = new StringBuilder();
            while((line = bufferedReader.readLine())!=null){
                stringBuilder.append(line+"\n");
            }
            bis.close();
            result = stringBuilder.toString();
            Log.d("data", result);
            //Toast.makeText(FeedbackActivity.this, "Content Received.!", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            //Toast.makeText(FeedbackActivity.this, "Content Failed.!", Toast.LENGTH_SHORT).show();
        }

        //JSON
        try {
            JSONArray jsonarray = new JSONArray(result);
            JSONObject jsonobject = null;
            name = new String[jsonarray.length()];
            StartStation = new String[jsonarray.length()];
            EndStation = new String[jsonarray.length()];
            time = new String[jsonarray.length()];
            type = new String[jsonarray.length()];
            Log.d("data", "received");


            for(int i=0;i<=jsonarray.length();i++){

                jsonobject = jsonarray.getJSONObject(i);
                name[i]=jsonobject.getString("name");
                StartStation[i]=jsonobject.getString("start_station");
                EndStation[i]=jsonobject.getString("end_station");
                time[i]=jsonobject.getString("time");
                type[i]=jsonobject.getString("type");


            }


        }catch(Exception e){
            e.printStackTrace();

        }
    }

}
