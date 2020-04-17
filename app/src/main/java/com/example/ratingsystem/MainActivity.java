package com.example.ratingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button lutton;
    RatingBar ratingbar;
    Button kutton;

    int myrating = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lutton = (Button) findViewById(R.id.button);
        ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        kutton = (Button) findViewById(R.id.button3);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int ratin = (int) v;

                String message = null;

                myrating = (int) ratingbar.getRating();
                switch (ratin){
                    case  1:
                        message = "sorry to hear that";
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







        kutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpopup();
            }
        });


    }
    public void getpopup(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("PLEASE SCROLL DOWN AND VOTE");

        WebView wv = new WebView(this);
        wv.loadUrl("https://bit.ly/asilimiaApp");
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });

        alert.setView(wv);
        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alert.show();

    }

}


