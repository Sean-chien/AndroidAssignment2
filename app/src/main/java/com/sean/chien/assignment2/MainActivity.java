package com.sean.chien.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mSpinner;
    private ImageView mposterTV;
    private TextView mSummaryTV;
    private static int[] imgRes = {
            R.drawable.catch_me_if_you_can,
            R.drawable.flight_club,
            R.drawable.forrest_gump,
            R.drawable.god_father,
            R.drawable.good_will_hunting,
            R.drawable.pulp_fiction,
            R.drawable.the_hangover,
            R.drawable.the_shawshank_redemption,
            R.drawable.titanic
    };

    private String[] summaryArray = {
            "catch_me_if_you_can",
            "flight_club",
            "forrest_gump",
            "god_father",
            "good_will_hunting",
            "pulp_fiction",
            "the_hangover",
            "the_shawshank_redemption",
            "titanic"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.spinner);
        mSpinner.setOnItemSelectedListener(this);
        mposterTV = findViewById(R.id.posterIV);
        mSummaryTV = findViewById(R.id.SummaryTV);

//        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                // your code goes here
//                Toast.makeText(getApplicationContext(), "Position" + position, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }

    private int getResId(String filename, String resType){
        int ResId = getResources().getIdentifier(filename, resType, getPackageName());
        return ResId;

    }

    private String getSummary(String name) {
        int resId = getResources().getIdentifier(name, "raw", getPackageName());
        String summary = "";
        Scanner in = new Scanner(getResources().openRawResource(resId));
        while (in.hasNext()){
            summary += (in.nextLine());
        }
        return summary;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // 1. get position -> which movie?
        // getResources() - res directory
        // getStringArray() = string - array
        String[] movies = getResources().getStringArray(R.array.movies);
        Toast.makeText(this, movies[position], Toast.LENGTH_LONG).show();

        // 2. display poster image in ImageView
        // TODO: how?
        ImageView posterIV = findViewById(R.id.posterIV);

        posterIV.setImageResource(imgRes[position]);

        // 3. display Summary text(View) in TextView
        String summary = getSummary(summaryArray[position]);
        TextView summaryTV = findViewById(R.id.SummaryTV);
        summaryTV.setText(summary);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
