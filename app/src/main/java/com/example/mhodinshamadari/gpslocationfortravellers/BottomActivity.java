package com.example.mhodinshamadari.gpslocationfortravellers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mhodinshamadari.gpslocationfortravellers.Messages.messages;
import com.example.mhodinshamadari.gpslocationfortravellers.emergency.Emergency;

public class BottomActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_map:
                    startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                    return true;
                case R.id.navigation_messages:
                    startActivity(new Intent(getApplicationContext(),messages.class));
                    return true;
                case R.id.navigation_emergency:
                    startActivity(new Intent(getApplicationContext(),Emergency.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
