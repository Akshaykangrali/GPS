package com.example.mhodinshamadari.gpslocationfortravellers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView feedback, about, addmembers, mymap;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //defininig card views
       feedback = (CardView) findViewById(R.id.feedbackid);
       about = (CardView) findViewById(R.id.aboutid);
       addmembers = (CardView) findViewById(R.id.addmembersid);
       mymap = (CardView) findViewById(R.id.mymapid);
       //add click listeners to card views
       feedback.setOnClickListener(this);
       about.setOnClickListener(this);
       addmembers.setOnClickListener(this);
       mymap.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.feedbackid : i = new Intent(this,Feedback.class);
                                 startActivity(i);
                                 break;

            case R.id.aboutid : i = new Intent(this,About.class);
                startActivity(i);

                break;

            case R.id.addmembersid : i = new Intent(this,add_members.class);
                startActivity(i);

                break;

            case R.id.mymapid : i = new Intent(this, Location.class);
                startActivity(i);

                break;
            default: break;
        }
        }
    }

