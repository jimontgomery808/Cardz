package com.example.josh.cardz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener
{
    private Button myCardz;
    private Button newCard;
    private Button quiz;
    private Button scores;
    private Button settings;
    private Button about;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        myCardz = (Button) findViewById(R.id.myCardz);
        myCardz.setOnClickListener(this);
        newCard = (Button) findViewById(R.id.newCardz);
        newCard.setOnClickListener(this);
        quiz = (Button) findViewById(R.id.quiz);
        quiz.setOnClickListener(this);
        scores = (Button) findViewById(R.id.scores);
        scores.setOnClickListener(this);
        settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(this);
        about = (Button) findViewById(R.id.about);
        about.setOnClickListener(this);


    }

    @Override public void onResume()
    {
        super.onResume();
        myCardz.setBackgroundColor(Color.parseColor("#303F9F"));
        //myCardz.setTextColor(Color.parseColor("#FFFFFF"));
        newCard.setBackgroundColor(Color.parseColor("#303F9F"));
        //newCard.setTextColor(Color.parseColor("#FFFFFF"));
        quiz.setBackgroundColor(Color.parseColor("#C5CAE9"));
        scores.setBackgroundColor(Color.parseColor("#C5CAE9"));
        settings.setBackgroundColor(Color.parseColor("#303F9F"));
        about.setBackgroundColor(Color.parseColor("#303F9F"));
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.myCardz:
                myCardz.setBackgroundColor(Color.LTGRAY);
                //myCardz.setTextColor(Color.BLACK);
                break;
            case R.id.newCardz:
                newCard .setBackgroundColor(Color.LTGRAY);
                //newCard.setTextColor(Color.BLACK);
                Intent intent = new Intent(MainMenu.this, CreateSet.class);
                startActivity(intent);
                break;
            case R.id.quiz:
                quiz.setBackgroundColor(Color.LTGRAY);
                //quiz.setTextColor(Color.BLACK);
                break;
            case R.id.scores:
                scores.setBackgroundColor(Color.LTGRAY);
                //scores.setTextColor(Color.BLACK);
                break;
            case R.id.settings:
                settings.setBackgroundColor(Color.LTGRAY);
                //settings.setTextColor(Color.BLACK);
                break;
            case R.id.about:
                about.setBackgroundColor(Color.LTGRAY);
                //about.setTextColor(Color.BLACK);
                break;

        }
    }

}
