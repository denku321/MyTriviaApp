package edu.oru.cit352.oluaki870.mytriviaapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {
    private Context context;
    private ArrayList user_name, html_highscore, css_highscore, js_highscore, wd_highscore;

    // Custom Adapter for Recycler view
    CustomAdaptor ( Activity activity, Context context, ArrayList user_name, ArrayList html_highscore, ArrayList css_highscore, ArrayList js_highscore,
                    ArrayList wd_highscore){
        this.context = context;
        this.user_name =user_name;
        this.html_highscore = html_highscore;
        this.css_highscore = css_highscore;
        this.js_highscore =js_highscore;
        this.wd_highscore = wd_highscore;

    }
    @NonNull
    @Override
    //Applys layout to Recycler view
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.highscore_rows, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    //Grabs highscore data from arraylist and sets text of each respecitve TextView
    public void onBindViewHolder(@NonNull CustomAdaptor.MyViewHolder holder, int position) {
        holder.username_txt.setText(String.valueOf(user_name.get(position)));
        holder.html_txt.setText(String.valueOf(html_highscore.get(position)));
        holder.css_txt.setText(String.valueOf(css_highscore.get(position)));
        holder.js_txt.setText(String.valueOf(js_highscore.get(position)));
        holder.wd_txt.setText(String.valueOf(wd_highscore.get(position)));

    }

    @Override
    //Grabs size of array list
    public int getItemCount() {
        return user_name.size();
    }

    //Stores each of the the TextViews in there respective arraylist
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView username_txt, html_txt, css_txt, js_txt, wd_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username_txt = itemView.findViewById(R.id.userName_txt);
            html_txt = itemView.findViewById(R.id.html_txt);
            css_txt = itemView.findViewById(R.id.css_txt);
            js_txt = itemView.findViewById(R.id.js_txt);
            wd_txt = itemView.findViewById(R.id.wd_txt);



        }
    }
}
