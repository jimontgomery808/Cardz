package com.example.josh.cardz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
        int[] colors = {Color.parseColor("#42A5F5"),Color.parseColor("#1565C0")};

        //create a new gradient color
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, colors);
        //apply the button background to newly created drawable gradient
        myCardz.setBackground(gd);
        myCardz.setTextColor(Color.WHITE);
        newCard.setBackground(gd);
        newCard.setTextColor(Color.WHITE);
        quiz.setBackground(gd);
        quiz.setTextColor(Color.WHITE);
        scores.setBackground(gd);
        scores.setTextColor(Color.WHITE);
        settings.setBackground(gd);
        settings.setTextColor(Color.WHITE);
        about.setBackground(gd);
        about.setTextColor(Color.WHITE);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.myCardz:
                myCardz.setBackgroundColor(Color.LTGRAY);
                myCardz.setTextColor(Color.BLACK);
                break;
            case R.id.newCardz:
                newCard .setBackgroundColor(Color.LTGRAY);
                newCard.setTextColor(Color.BLACK);
                Intent intent = new Intent(MainMenu.this, CreateSet.class);
                startActivity(intent);
                break;
            case R.id.quiz:
                quiz.setBackgroundColor(Color.LTGRAY);
                quiz.setTextColor(Color.BLACK);
                break;
            case R.id.scores:
                scores.setBackgroundColor(Color.LTGRAY);
                scores.setTextColor(Color.BLACK);
                break;
            case R.id.settings:
                settings.setBackgroundColor(Color.LTGRAY);
                settings.setTextColor(Color.BLACK);
                break;
            case R.id.about:
                about.setBackgroundColor(Color.LTGRAY);
                about.setTextColor(Color.BLACK);
                break;

        }
    }

}
