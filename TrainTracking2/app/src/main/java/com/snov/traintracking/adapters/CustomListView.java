package com.snov.traintracking.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.snov.traintracking.R;
import com.snov.traintracking.activities.FeedbackActivity;

/**
 * Created by Shamalka Navod on 2018-08-30.
 */
public class CustomListView extends ArrayAdapter<String> {

    private String[] TrainName;
    private String[] StartStation;
    private String[] EndStation;
    private String[] Time;
    private String[] Type;
    private Activity context;

    public CustomListView(Activity context, String[] TrainName, String[] StartStaion, String[] EndStation, String[] Time, String[] Type) {
        super(context, R.layout.activity_feedback, TrainName);
        this.context = context;
        this.TrainName = TrainName;
        this.StartStation = StartStaion;
        this.EndStation = EndStation;
        this.Time = Time;
        this.Type = Type;
    }



    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.trains_list_item,null,true);
            r.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Go to description", Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)r.getTag();
        }

        viewHolder.train_name.setText(TrainName[position]);
        viewHolder.start_st.setText(StartStation[position]);
        viewHolder.end_st.setText(EndStation[position]);
        viewHolder.train_time.setText(Time[position]);
        viewHolder.train_type.setText(Type[position]);

        return r;
    }

    class ViewHolder{
        TextView train_name;
        TextView start_st;
        TextView end_st;
        TextView train_time;
        TextView train_type;

        ViewHolder(View v){
            train_name = (TextView)v.findViewById(R.id.name);
            start_st = (TextView)v.findViewById(R.id.start);
            end_st = (TextView)v.findViewById(R.id.end);
            train_time = (TextView)v.findViewById(R.id.time);
            train_type = (TextView)v.findViewById(R.id.type);
        }


    }
}
