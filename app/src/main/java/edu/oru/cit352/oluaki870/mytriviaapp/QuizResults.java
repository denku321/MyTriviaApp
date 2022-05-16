package edu.oru.cit352.oluaki870.mytriviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class QuizResults extends AppCompatActivity {
    String currUser;
    String topic;
    double getResults;
    String html = "0.0";
    String css ="0.0";
    String js = "0.0";
    String wd = "0.0";
    MyDBHelper myDB = new MyDBHelper(QuizResults.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final AppCompatButton startNewBtn =  findViewById(R.id.startNewQuizBtn);
        final TextView correctAnswers = findViewById(R.id.correctAnswers);
        final TextView incorrectAnswers = findViewById(R.id.incorrectAnswers);
        final TextView results = findViewById(R.id.resultsTextView);
        final TextView success = findViewById(R.id.successTextView);

        final int getCorrectAnswers = getIntent().getIntExtra("correct",0);
        final int getIncorrectAnswers = getIntent().getIntExtra("incorrect", 0);


        success.setText(getIntent().getStringExtra("oot"));
        if (success.getText() == ""){
            success.setText("You've successfully completed a quiz");
        }

        currUser = getIntent().getStringExtra("username");
        topic = getIntent().getStringExtra("topic");

        Cursor cursor = myDB.readAllData(currUser);
        if(cursor.getCount() == 0){
            Toast.makeText(QuizResults.this,"No data.", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()) {
                if(cursor.getString(1) != null) {
                    html = cursor.getString(1);
                }
                if(cursor.getString(2) != null) {
                    css = cursor.getString(2);
                }
                if(cursor.getString(3) != null) {
                    js = cursor.getString(3);
                }
                if(cursor.getString(4) != null) {
                    wd = cursor.getString(4);
                }
            }
        }

        //Round results to 2 decimal places and calculate result
        getResults = Math.round((((double) getCorrectAnswers/15)*100.0)*100.0)/100.0;

        //Set the text of the TextViews with there respective information
        correctAnswers.setText("Correct Answers : " + String.valueOf(getCorrectAnswers));
        incorrectAnswers.setText("Incorrect Answers : " + String.valueOf(getIncorrectAnswers));
        results.setText("Final Result : " + String.valueOf(getResults) + "%");

        // On click of start new quiz button
        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //switch to IntroActivity pass the current user
                Intent intent = new Intent(QuizResults.this, IntroActivity.class);
                intent.putExtra("username", currUser);

                //Check the topic and check if the current highscore is lower than the new score,
                //if so replace
                if(topic.equals("html") && Float.parseFloat(html) < getResults) {
                    myDB.addHTMLHighscore(currUser, getResults);
                } else if(topic.equals("css") && Float.parseFloat(css) < getResults) {
                    myDB.addCSSHighscore(currUser, getResults);
                } else if(topic.equals("js") && Float.parseFloat(js) < getResults) {
                    myDB.addJSHighscore(currUser, getResults);
                } else if(topic.equals("webDev") && Float.parseFloat(wd) < getResults) {
                    myDB.addWDHighscore(currUser, getResults);
                }

                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    //On back button pressed, do the same as start new button: store the users results if
    // higher than current highscore
    public void onBackPressed() {
        Intent intent = new Intent(QuizResults.this, IntroActivity.class);
        intent.putExtra("username", currUser);

        if(topic.equals("html") && Float.parseFloat(html) < getResults) {
            myDB.addHTMLHighscore(currUser, getResults);
        } else if(topic.equals("css") && Float.parseFloat(css) < getResults) {
            myDB.addCSSHighscore(currUser, getResults);
        } else if(topic.equals("js") && Float.parseFloat(js) < getResults) {
            myDB.addJSHighscore(currUser, getResults);
        } else if(topic.equals("webDev") && Float.parseFloat(wd) < getResults) {
            myDB.addWDHighscore(currUser, getResults);
        }

        startActivity(intent);
        finish();
    }
}