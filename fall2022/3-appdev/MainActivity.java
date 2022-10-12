package com.example.simpletestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set new numbers on application start
        setNewNumbers();
    }

    // Function called on button click event
    public void onSubmitClick (View view){

        // Get current numbers from view text and convert to integers
        TextView Number1 = findViewById(R.id.Number1);
        TextView Number2 = findViewById(R.id.Number2);
        int value1 = Integer.parseInt(Number1.getText().toString());
        int value2 = Integer.parseInt(Number2.getText().toString());

        // Get user answer from view and convert to integer
        EditText Attempt = findViewById(R.id.Attempt);
        int userAnswer = Integer.parseInt(Attempt.getText().toString());

        TextView Result = findViewById(R.id.Result);

        // If user answer is equivalent to the sum of the numbers, set result text to Correct
        if(userAnswer == value1+value2) {
            Result.setText("Correct!");
        }
        // Else set result text to wrong and show correct answer
        else {
            Result.setText("Wrong, the correct answer was: " + (value1+value2));
        }

        // Set numbers to new random values
        setNewNumbers();
    }


    private void setNewNumbers () {
        // Get new random integers between 0 and 100
        Random r = new Random();
        int value1 = r.nextInt(100);
        int value2 = r.nextInt(100);

        // Set number TextViews to new values
        TextView Number1 = findViewById(R.id.Number1);
        TextView Number2 = findViewById(R.id.Number2);
        Number1.setText(""+value1);
        Number2.setText(""+value2);

        // Clear previous attempt
        EditText Attempt = findViewById(R.id.Attempt);
        Attempt.setText("");
    }

}