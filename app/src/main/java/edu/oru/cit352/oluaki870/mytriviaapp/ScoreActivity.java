package edu.oru.cit352.oluaki870.mytriviaapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {
    //Declare Variables
    RecyclerView highscore;
    MyDBHelper myDB;
    ArrayList<String> user_name, html_highscore, css_highscore, js_highscore, wd_highscore;
    String username;
    CustomAdaptor customAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

        //Grab username from intent/other Activities
        username = getIntent().getStringExtra("username");

        //store high school recycler view object
        highscore = findViewById(R.id.highscoreRecyclerView);

        myDB =  new MyDBHelper(ScoreActivity.this);
        //  Create array lists  for each of the values needed to be displayed (could be strings)
        user_name = new ArrayList<>();
        html_highscore = new ArrayList<>();
        css_highscore = new ArrayList<>();
        js_highscore = new ArrayList<>();
        wd_highscore = new ArrayList<>();

        // Grabs data from DB and stores in their respective array list
        displayData();

        // Creates custom adapter object with loaded values
        customAdaptor = new CustomAdaptor(ScoreActivity.this, this, user_name,html_highscore,css_highscore,js_highscore,wd_highscore);
        // applies custom adaptor on the RecyclerView object
        highscore.setAdapter(customAdaptor);
        //sets the layout of the recycler view
        highscore.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));

    }

    @Override
    // Was attempted to be used to reload activity if called, but reloads already
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    // Display data
    void displayData () {
        // calls readAllData function in Database
        Cursor cursor = myDB.readAllData(username);
        //checks if the database is not empty
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data.", Toast.LENGTH_SHORT).show();
        }else {
            //Reads all data that is equal to the current user logged in and adds it to the respective array list
            //to be outputed onto Highscore page
            while(cursor.moveToNext()){
                user_name.add(cursor.getString(0) + "'s Highscores");

                //checks if cursor is pointing to null -> user has not taken the quiz print out 0% default
                if(cursor.getString(1) != null) {
                    html_highscore.add("HTML Quiz: " + cursor.getString(1) + "%");
                }else{
                    html_highscore.add("HTML Quiz: 0%");
                }
                if(cursor.getString(2) != null) {
                    css_highscore.add("CSS Quiz: " + cursor.getString(2) + "%");
                }else{
                    css_highscore.add("CSS Quiz: 0%");
                }
                if(cursor.getString(3) != null) {
                    js_highscore.add("JS Quiz: " + cursor.getString(3) + "%");
                }else{
                    js_highscore.add("JS Quiz: 0%");
                }
                if(cursor.getString(4) != null) {
                    wd_highscore.add("Web Dev Quiz: " + cursor.getString(4) + "%");
                }else{
                    wd_highscore.add("Web Dev Quiz: 0%");
                }
            }
        }

    }


}
