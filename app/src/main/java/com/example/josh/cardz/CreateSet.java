package com.example.josh.cardz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateSet extends AppCompatActivity
{
    private static final String[] SUBJECTS = new String[]
    {
                    " 3-D art",
                    "Anatomy and Physiology",
                    "Aerobics",
                    "Agriculture",
                    "Algebra 1",
                    "Algebra 2",
                    "American Sign Language",
                    "Ancient Greek",
                    "AP Art history",
                    "AP Biology",
                    "AP Calculus AB",
                    "AP Calculus BC",
                    "AP Capstones",
                    "AP Chemistry",
                    "AP Chinese Language and Culture",
                    "AP Comparative government and politics",
                    "AP Computer Science A",
                    "AP Computer Science Principles",
                    "AP English Language and Composition",
                    "AP English Literature and Composition",
                    "AP Environmental Science",
                    "AP European history",
                    "AP French Language and Culture",
                    "AP German Language and Culture",
                    "AP Human Geography",
                    "AP Italian Language and Culture",
                    "AP Japanese Language and Culture",
                    "AP Latin",
                    "AP Macroeconomics",
                    "AP Microeconomics",
                    "AP Music theory",
                    "AP Physics 1: Algebra-Based",
                    "AP Physics 2: Algebra-Based",
                    "AP Physics C: Electricity and Magnetism",
                    "AP Psychology",
                    "AP Research",
                    "AP Seminar",
                    "AP Spanish Language and Culture",
                    "AP Spanish Literature and Culture",
                    "AP Statistics",
                    "AP Studio art: 2-D design",
                    "AP Studio art: 3-D design",
                    "AP Studio art: drawing",
                    "AP United States Government and Politics",
                    "AP United States History",
                    "AP World History",
                    "Arabic",
                    "Art history",
                    "Astronomy",
                    "Auto body repair",
                    "Auto mechanics",
                    "Biology",
                    "Botany",
                    "Building construction",
                    "Calculus",
                    "Ceramics",
                    "Chemistry",
                    "Chinese",
                    "Choir",
                    "Computer math",
                    "Computer-aided drafting",
                    "Concert band",
                    "Consumer math",
                    "Cosmetology",
                    "Criminal justice",
                    "Cultural anthropology",
                    "Current events",
                    "Dance",
                    "Dance",
                    "Digital media",
                    "Drama",
                    "Drawing",
                    "Driver education",
                    "Earth science",
                    "Electronics",
                    "Electronics",
                    "Environmental science",
                    "Environmental studies",
                    "European history",
                    "Film production",
                    "Fire science",
                    "Forensic science",
                    "French",
                    "Fundamentals of math",
                    "Geography",
                    "Geology",
                    "Geometry",
                    "German",
                    "Global studies",
                    "Guitar",
                    "Gymnastics",
                    "Health",
                    "Heating and cooling systems",
                    "Hebrew",
                    "Hospitality and tourism",
                    "Human geography",
                    "Integrated math",
                    "International relations",
                    "Italian",
                    "Japanese",
                    "Jazz band",
                    "Jewelry design",
                    "JROTC",
                    "Korean",
                    "Latin",
                    "Law",
                    "Lifeguard training",
                    "Macroeconomics",
                    "Marching band",
                    "Marine biology",
                    "Math & Computer Science",
                    "Math applications",
                    "Metalworking",
                    "Microeconomics",
                    "Modern world studies",
                    "Multivariable calculus",
                    "Music theory",
                    "Networking",
                    "Oceanography",
                    "Orchestra",
                    "Painting",
                    "Percussion",
                    "Photography",
                    "Physical anthropology",
                    "Physical science",
                    "Physics",
                    "Piano  ",
                    "Pilates",
                    "Plumbing",
                    "Political studies",
                    "Portuguese",
                    "Practical math",
                    "Pre-algebra",
                    "Pre-calculus",
                    "Printmaking",
                    "Probability",
                    "Production technology",
                    "Psychology",
                    "Quantitative literacy",
                    "Racket sports",
                    "Refrigeration fundamentals",
                    "Religious studies",
                    "Robotics",
                    "Russian",
                    "Sculpture",
                    "Sociology",
                    "Spanish",
                    "Specialized sports",
                    "Statistics",
                    "Swimming",
                    "Theater technology",
                    "Trigonometry",
                    "US government",
                    "US history",
                    "Weight training",
                    "Women’s studies",
                    "Woodworking",
                    "World history",
                    "World music",
                    "World politics",
                    "World religions",
                    "Zoology"
    };
    private EditText title;
    private AutoCompleteTextView subject;
    private Button next;
    private Button back;
    private List<String> subjectList = new ArrayList<>(Arrays.asList(SUBJECTS));
    private ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_set);

        title = (EditText) findViewById(R.id.title_text);
        subject = (AutoCompleteTextView) findViewById(R.id.subject_text);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, subjectList);
        subject.setAdapter(adapter);

        next = (Button) findViewById(R.id.next_bttn);
        back = (Button) findViewById(R.id.back_bttn);

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!title.getText().toString().equals("") && !subject.getText().toString().equals(""))
                {
                    Intent intent = new Intent(CreateSet.this, NewCard.class);
                    intent.putExtra("set_name", title.getText().toString());
                    intent.putExtra("subject", subject.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Please enter a name and subject for your Cardz",Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });


    }

    @Override
    public void onResume()
    {
        super.onResume();
    }


}
