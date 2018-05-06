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
 * Created by mhodinshamadari on 29-03-2018.
 */

public class UserInformation extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    TextView phonenumber;
    Button save;
     private FirebaseUser user;

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_information);

        firebaseAuth = FirebaseAuth.getInstance();
        username =findViewById(R.id.feed);
        phonenumber =findViewById(R.id.phonenumber);
        save = findViewById(R.id.save);
        save.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
      /*  if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));

        }
      /* if (firebaseAuth.getCurrentUser() != null) {
           //close this activity
           finish();
           //start login activity
           startActivity(new Intent(this,HomeActivity.class));
       }*/
                //findViewById(R.id.save).setOnClickListener(this);
       // user = new User();

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        FirebaseUser user = firebaseAuth.getCurrentUser();

        phonenumber.setText(user.getPhoneNumber());

    }


    private void Userinfo() {

        String name = username.getText().toString().trim();
        String number = phonenumber.getText().toString().trim();
        User myuser =new User(name,number);

            if (name.isEmpty()) {

                username.setError("username is required");
                username.requestFocus();
                return;

            }
           // String uid =FirebaseAuth.getInstance().getCurrentUser().getUid();
        //FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
        databaseReference.child(user.getPhoneNumber()).setValue(myuser);
        Toast.makeText(this,"Information Saved.....",Toast.LENGTH_LONG).show();
    }




    @Override
    public void onClick(View view) {

        if (view == save){
            Userinfo();
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        }

    }


}

