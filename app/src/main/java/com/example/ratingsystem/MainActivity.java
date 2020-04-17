package com.example.ratingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button lutton;
    RatingBar ratingbar;
    int myrating = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lutton = (Button) findViewById(R.id.button);
        ratingbar = (RatingBar) findViewById(R.id.ratingbar);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int ratin = (int) v;

                String message = null;

                myrating = (int) ratingbar.getRating();
                switch (ratin){
                    case  1:
                        message = "sorru to hear that";
                        break;
                    case 2:
                        message = "you always accept suggestions";
                        break;
                    case 3:
                        message = "Good enough";
                        break;
                    case 4:
                        message = "Great! Thank you!";
                        break;
                    case 5:
                        message ="Awesome, You are the best ";
                        break;
                }
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });

        lutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Your rating is: "  +myrating,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
