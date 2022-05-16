package edu.oru.cit352.oluaki870.mytriviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {

    //Declare Variables
    private String selectedTopicName = "";
    String currUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Store Layout objects
        final LinearLayout html = findViewById(R.id.htmlLayout);
        final LinearLayout css =  findViewById(R.id.cssLayout);
        final LinearLayout js = findViewById(R.id.jsLayout);
        final LinearLayout webDev = findViewById(R.id.webDevLayout);
        final TextView choose = findViewById(R.id.chooseTopic);

        //Store button objects
        final Button startBtn = findViewById(R.id.startQuizBtn);
        final Button highscoreBtn = findViewById(R.id.highscoreBtn);

        // Grab and store the username from other layouts
        currUser = getIntent().getStringExtra("username");

        //Print a welcome text
        choose.setText("Hello " + currUser + ", choose a topic:");

        //On click of the html layout highlight and store the selected topic name
        html.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                selectedTopicName = "html";

                html.setBackgroundResource(R.drawable.round_back_white_stroke10);

                css.setBackgroundResource(R.drawable.round_back_white10);

                js.setBackgroundResource(R.drawable.round_back_white10);

                webDev.setBackgroundResource(R.drawable.round_back_white10);



            }
        });

        //On click of the css layout highlight and store the selected topic name
        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "css";

                html.setBackgroundResource(R.drawable.round_back_white10);

                css.setBackgroundResource(R.drawable.round_back_white_stroke10);

                js.setBackgroundResource(R.drawable.round_back_white10);

                webDev.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        //On click of the js layout highlight and store the selected topic name
        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "js";

                html.setBackgroundResource(R.drawable.round_back_white10);

                css.setBackgroundResource(R.drawable.round_back_white10);

                js.setBackgroundResource(R.drawable.round_back_white_stroke10);

                webDev.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        //On click of the WebDev layout highlight and store the selected topic name
        webDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "webDev";

                html.setBackgroundResource(R.drawable.round_back_white10);

                css.setBackgroundResource(R.drawable.round_back_white10);

                js.setBackgroundResource(R.drawable.round_back_white10);

                webDev.setBackgroundResource(R.drawable.round_back_white_stroke10);
            }
        });

        //On click of the start button
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if there is a topic selected a.k.a is selectedTopicName Empty
                if(selectedTopicName.isEmpty()) {
                    //Print a message to screen for the user to select a topic
                    Toast.makeText(IntroActivity.this, "Please select the Topic", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Otherwise switch to the QuizActivity and pass the topic name and username
                    Intent intent = new Intent(IntroActivity.this,QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    intent.putExtra("username", currUser);
                    startActivity(intent);
                }
            }
        });

        //On click of the highscore button
        highscoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Switch to the ScoreActivity and pass the username
                Intent intent = new Intent(IntroActivity.this,ScoreActivity.class);
                intent.putExtra("username", currUser);
                startActivity(intent);
            }
        });
    }

    @Override
    //When the back button is pressed do nothing so the user cant return to the enter username page
    public void onBackPressed() {
        // Do nothing;
    }

}