package edu.oru.cit352.oluaki870.mytriviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    // Declare Variables
    private TextView questions;
    private TextView question;

    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int totalTimeInMins = 1;

    private int seconds = 0;

    private List<QuestionsList> questionsLists;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // Store Imageview and TextView Objects
        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.topicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextBtn = findViewById(R.id.nextBtn);

        // Get the selectedTopicName and current user from other Activities
        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");
        final String currUser = getIntent().getStringExtra("username");

        //Set the text of the quiz header to the name of the topic selected
        selectedTopicName.setText(getSelectedTopicName);

        //Grab and Store the respective questionsList based off of the tapic name selected
        questionsLists = QuestionsBank.getQuestions(getSelectedTopicName);

        //Timer function, sets a timeout of 60 seconds
        startTimer(timer,currUser,getSelectedTopicName);

        //set text of all the questions and options for the user to choose from, from the questionsList array
        questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());

        //On click of option 1, grab the text and compare it with the answer, if correct light green, else red
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = option1.getText().toString();

                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        //On click of option 2, grab the text and compare it with the answer, if correct light green, else red
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = option2.getText().toString();

                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        //On click of option 3, grab the text and compare it with the answer, if correct light green, else red
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = option3.getText().toString();

                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        //On click of option 4, grab the text and compare it with the answer, if correct light green, else red
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = option4.getText().toString();

                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        //On click of nextBtn check if answer is selected, if not error message, else switch to next question
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this,"Please select an option", Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion(currUser,getSelectedTopicName);
                }
            }
        });

        //On back button pressed cancel timer and switch back to IntroActivity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               quizTimer.purge();
               quizTimer.cancel();

               startActivity(new Intent(QuizActivity.this, IntroActivity.class));
               finish();
            }
        });



    }
    // Change questions iterates through the array updating the questions, if last value in the array changes
    //next buttons text to Submit Quiz and cancels the timer
    private void changeNextQuestion(String currUser, String topic){

        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionsLists.size()){
            nextBtn.setText("Submit Quiz");
        }

        if(currentQuestionPosition < questionsLists.size()){

            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());

        }
        else {
            quizTimer.purge();
            quizTimer.cancel();

            // Upon submition pass the number of correct and incorrect quesitons, username, and topic to QuizResults Activity
            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getIncorrectAnswers());
            intent.putExtra("username", currUser);
            intent.putExtra("topic", topic);
            startActivity(intent);

            finish();
        }
    }

    // Creates timer object, sets a timer of 59 seconds, once seconds hits 0, timeout the quiz
    //and switch to QuizResults activity
    private void startTimer(TextView timerTextView, String currUser, String topic) {

        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){

                if(seconds == 0 && totalTimeInMins == 0){

                    quizTimer.purge();
                    quizTimer.cancel();
                    //Upon timeout, pass same values as completion of quiz + timeout message message
                    //oot = out of time
                    Intent intent = new Intent(QuizActivity.this, QuizResults.class);
                    intent.putExtra("username", currUser);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("incorrect", getIncorrectAnswers());
                    intent.putExtra("topic", topic);
                    intent.putExtra("oot","You ran out of time!");
                    startActivity(intent);

                    finish();
                }
                else  if(seconds == 0){
                    totalTimeInMins--;
                    seconds = 59;

                }
                else{
                    seconds--;
                }
                //Thread that handles the switching of the values on the timer
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1){
                            finalMinutes = "0" + finalMinutes;
                        }

                        if(finalSeconds.length() == 1){
                            finalSeconds ="0" +finalSeconds;
                        }
                        // Upon timeout print timeout error message onto the screen
                        if (seconds == 0 && totalTimeInMins == 0){
                            Toast.makeText(QuizActivity.this, "Time Over", Toast.LENGTH_SHORT).show();
                        }

                        timerTextView.setText(finalMinutes+":"+finalSeconds);
                    }
                });
            }
        }, 1000,1000);

    }

    //Calculates number of correct answers
    private  int getCorrectAnswers(){

        int correctAnswers = 0;

        for(int i = 0; i<questionsLists.size(); i++){

            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    //Calculates number of incorrect answers
    private  int getIncorrectAnswers(){

        int incorrectAnswers = 0;

        for(int i = 0; i<questionsLists.size(); i++){

            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer)){
                incorrectAnswers++;
            }
        }
        return incorrectAnswers;
    }

    //onBackPressed cancel timer and switch to IntroActivity
    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, IntroActivity.class));
        finish();
    }

    //Function that sets wrong answer chosen to red and highlights correct answer green
    //Or just highlights correct answer green if correct answer is chosen
    private void revealAnswer() {

        final String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

        if(option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
}