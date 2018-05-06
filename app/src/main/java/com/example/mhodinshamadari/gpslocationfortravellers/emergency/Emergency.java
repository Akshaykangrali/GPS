package com.example.mhodinshamadari.gpslocationfortravellers.emergency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.example.mhodinshamadari.gpslocationfortravellers.R;

/**
 * Created by mhodinshamadari on 23-04-2018.
 */

public class Emergency extends AppCompatActivity implements View.OnClickListener {

     CardView fuel, air, accident, others;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergancy);
        //defininig card views
        fuel = (CardView) findViewById(R.id.fuelid);
        air = (CardView) findViewById(R.id.airid);
        accident = (CardView) findViewById(R.id.accidentid);
        others = (CardView) findViewById(R.id.othersid);
        //add click listeners to card views
        fuel.setOnClickListener(this);
        air.setOnClickListener(this);
        accident.setOnClickListener(this);
        others.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.fuelid :
                Toast.makeText(this,"this is for out of fuel.....",Toast.LENGTH_LONG).show();

                break;

            case R.id.airid :
                Toast.makeText(this,"this is for low air.....",Toast.LENGTH_LONG).show();
                break;

            case R.id.accidentid :
                Toast.makeText(this,"this is for accident.....",Toast.LENGTH_LONG).show();
                break;

            case R.id.othersid :
                Toast.makeText(this,"this is for others.....",Toast.LENGTH_LONG).show();
                break;
            default: break;
        }
    }
}
