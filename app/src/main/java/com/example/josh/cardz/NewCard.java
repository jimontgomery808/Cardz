package com.example.josh.cardz;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewCard extends AppCompatActivity
{
    private EditText answer;
    private EditText definition;
    private Button searchBttn;
    private Button addButton;
    private Button saveButton;
    private List<Card> cardList = new ArrayList<>();
    private int cardCount;
    private String lastCard;
    private TextView cardCountTextView;
    private TextView previous;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);

        String title = getIntent().getStringExtra("set_name");
        String subject = getIntent().getStringExtra("subject");
        this.setTitle(title + "(" + subject + ")");

        cardCount = 0;

        answer = (EditText) findViewById(R.id.answer);
        searchBttn = (Button) findViewById(R.id.searchView);
        addButton = (Button) findViewById(R.id.addButton);
        definition = (EditText) findViewById(R.id.definition);
        cardCountTextView = (TextView) findViewById(R.id.card_count);
        saveButton = (Button) findViewById(R.id.saveButton);
        previous = (TextView) findViewById(R.id.previous);
        setCount();


        searchBttn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    String term = answer.getText().toString() + " definition";
                    intent.putExtra(SearchManager.QUERY, term);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    // TODO: handle exception
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!answer.getText().toString().equals("") && !definition.getText().toString().equals(""))
                {
                    Card card = new Card();
                    card.setTerm(answer.getText().toString());
                    card.setDefinition(definition.getText().toString().trim());
                    cardList.add(card);
                    lastCard = answer.getText().toString();
                    answer.setText("");
                    definition.setText("");
                    Toast.makeText(getBaseContext(),"Added card to collection",Toast.LENGTH_SHORT).show();
                    cardCount ++;
                    setCount();

                }
                else
                {
                    Toast.makeText(getBaseContext(),answer.getText().toString(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(getBaseContext(),definition.getText().toString(),Toast.LENGTH_SHORT).show();


                    Toast.makeText(getBaseContext(),"Please enter an answer and definition for this card",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setCount()
    {
        String countMessage = "";
        String previousMessage = "";
        if(cardCount == 1)
        {
            countMessage = Integer.toString(cardCount) + " card in this set";
        }
        else
        {
            countMessage = Integer.toString(cardCount) + " cards in this set";
        }
        if(cardCount > 0)
        {
            previousMessage += "Previous: " + lastCard;
            previous.setText(previousMessage);
        }

        cardCountTextView.setText(countMessage);
    }
}
