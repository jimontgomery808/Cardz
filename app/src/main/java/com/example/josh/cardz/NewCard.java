package com.example.josh.cardz;


import android.app.SearchManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    private EditText term;
    private LinedEditText definition;
    private Button searchBttn;
    private Button addButton;
    private Button saveButton;
    private Button pasteButton;
    private Button clearButton;
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

        term              = (EditText) findViewById(R.id.answer);
        searchBttn        = (Button) findViewById(R.id.searchView);
        addButton         = (Button) findViewById(R.id.addButton);
        pasteButton       = (Button) findViewById(R.id.paste_bttn);
        clearButton       = (Button) findViewById(R.id.clear_bttn);
        saveButton        = (Button) findViewById(R.id.saveButton);
        definition        = (LinedEditText) findViewById(R.id.definition);
        cardCountTextView = (TextView) findViewById(R.id.card_count);
        previous          = (TextView) findViewById(R.id.previous);

        setCount();


        searchBttn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(term.getText().toString().equals(""))
                {
                    Toast.makeText(getBaseContext(),"Search field is empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try
                    {
                        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        String query = term.getText().toString() + " definition";
                        intent.putExtra(SearchManager.QUERY, query);
                        startActivity(intent);
                    } catch (Exception e)
                    {
                        // TODO: handle exception
                    }
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!term.getText().toString().equals("") && !definition.getText().toString().equals(""))
                {
                    Card card = new Card();
                    card.setTerm(term.getText().toString());
                    card.setDefinition(definition.getText().toString().trim());
                    cardList.add(card);
                    lastCard = term.getText().toString();
                    term.setText("");
                    definition.setText("");
                    Toast.makeText(getBaseContext(),"Added card to collection",Toast.LENGTH_SHORT).show();
                    cardCount ++;
                    setCount();

                }
                else
                {
                    Toast.makeText(getBaseContext(),"Please enter a term and definition for this card",Toast.LENGTH_SHORT).show();
                }
            }
        });

        pasteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!definition.equals(""))
                {
                    definition.setText("");
                }
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = clipboard.getPrimaryClip();
                clipboard.setPrimaryClip(clip);
                definition.setText(clip.getItemAt(0).getText());
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                definition.setText(null);
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

    @Override
    public void onBackPressed()
    {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("EXITING SCREEN");
        alertDialogBuilder.setMessage("Any unsaved data will be lost, do you wish to go back?").setCancelable(false).setPositiveButton("Yes",new DialogInterface.OnClickListener()
        {
                    public void onClick(DialogInterface dialog,int id)
                    {
                        finish();
                    }
        }).setNegativeButton("No",new DialogInterface.OnClickListener()
        {
                    public void onClick(DialogInterface dialog,int id)
                    {
                        dialog.cancel();
                    }
        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

}
