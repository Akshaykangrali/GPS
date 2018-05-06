package com.example.mhodinshamadari.gpslocationfortravellers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mhodinshamadari on 19-04-2018.
 */

public class About extends AppCompatActivity {

    private TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        about = (TextView) findViewById(R.id.about);
    }

}
