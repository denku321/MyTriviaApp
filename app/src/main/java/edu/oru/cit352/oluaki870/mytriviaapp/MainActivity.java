package edu.oru.cit352.oluaki870.mytriviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username;
    AppCompatButton continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Store Edit Text and Button objects
        username = findViewById(R.id.usernameEditText);
        continueBtn = findViewById(R.id.continueBtn);

        //On click of the continue button
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Store the username entered into the database
                MyDBHelper myDB = new MyDBHelper(MainActivity.this);
                myDB.addUsername(username.getText().toString().trim());

                //Switch to the IntroActivity and pass the username
                Intent intent = new Intent(MainActivity.this, IntroActivity.class);
                intent.putExtra("username",username.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}