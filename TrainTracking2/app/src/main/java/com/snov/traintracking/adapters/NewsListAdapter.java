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
public class NewsListAdapter extends ArrayAdapter<String> {

    private String[] NewsTitle;
    private String[] NewsAuthor;
    private String[] NewsDate;
    private Activity context;

    public NewsListAdapter(Activity context, String[] NewsTitle, String[] NewsAuthor, String[] NewsDate) {
        super(context, R.layout.activity_news, NewsTitle);
        this.context = context;
        this.NewsTitle = NewsTitle;
        this.NewsAuthor = NewsAuthor;
        this.NewsDate = NewsDate;
    }



    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.news_list_item,null,true);
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

        viewHolder.news_title.setText(NewsTitle[position]);
        viewHolder.news_author.setText(NewsAuthor[position]);
        viewHolder.news_date.setText(NewsDate[position]);


        return r;
    }

    class ViewHolder{
        TextView news_title;
        TextView news_author;
        TextView news_date;


        ViewHolder(View v){
            news_title = (TextView)v.findViewById(R.id.title);
            news_author = (TextView)v.findViewById(R.id.author);
            news_date = (TextView)v.findViewById(R.id.date);
        }


    }
}
