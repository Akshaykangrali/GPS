package com.example.mhodinshamadari.gpslocationfortravellers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mhodinshamadari on 17-04-2018.
 */

public class Feedback extends AppCompatActivity implements View.OnClickListener {
    EditText feed;
    Button sent;
    TextView thankyou, back;
   // Button save;
    private FirebaseUser user;

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        firebaseAuth = FirebaseAuth.getInstance();
        feed =findViewById(R.id.feed);
        sent =findViewById(R.id.save);
        //thankyou=findViewById(R.id.thankyou);
        //back = findViewById(R.id.back);
        //btn_fb = findViewById(R.id.sent);
        sent.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

      /* if (firebaseAuth.getCurrentUser() != null) {
           //close this activity
           finish();
           //start login activity
           startActivity(new Intent(this,HomeActivity.class));
       }*/
        //findViewById(R.id.save).setOnClickListener(this);
        // user = new User();

        databaseReference = FirebaseDatabase.getInstance().getReference("feedbacks");

        FirebaseUser user = firebaseAuth.getCurrentUser();

        //textviewnumber.setText("thank you " +user.getPhoneNumber());

    }


    private void Userinfo() {

        String feedbacks = feed.getText().toString().trim();
        //User myuser;
        txt myfeed =new txt(feedbacks);

        if (feedbacks.isEmpty()) {

            feed.setError("empty feedback can not be sent");
            feed.requestFocus();
            return;

        }
        // String uid =FirebaseAuth.getInstance().getCurrentUser().getUid();
        //FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
        DatabaseReference newRef =databaseReference.child(user.getPhoneNumber()).push();
        newRef.setValue(myfeed);
        Toast.makeText(this,"Your Feedback Is Appriciated.....",Toast.LENGTH_LONG).show();
       /* feed.setVisibility(View.GONE);
        sent.setVisibility(View.GONE);
        thankyou.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);*/
    }




    @Override
    public void onClick(View view) {

        if (view == sent){
            Userinfo();

            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        }

    }
}

