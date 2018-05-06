package com.example.mhodinshamadari.gpslocationfortravellers.Messages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mhodinshamadari.gpslocationfortravellers.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mhodinshamadari on 23-04-2018.
 */

public class messages extends AppCompatActivity implements View.OnClickListener{
    RecyclerView mListmessage;
    ListMessageAdapter mAdapter;
    TextView emsg;
    Button msg_btn;
    DatabaseReference databaseReference;
    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private RecyclerView mMessageList;
    String mUsername;
    EditText username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        emsg = findViewById(R.id.etmsg);
        msg_btn = findViewById(R.id.msg_btn);
        FirebaseUser user = firebaseAuth.getCurrentUser();

      //  Bundle extras = getIntent().getExtras();
        mUsername = user.getPhoneNumber();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("messages");
        mListmessage =(RecyclerView)findViewById(R.id.list_msg);
        mAdapter = new ListMessageAdapter(this,databaseReference);
        mListmessage.setLayoutManager(new LinearLayoutManager(this));
        mListmessage.setAdapter(mAdapter);
        msg_btn.setOnClickListener(this);

    }

  /*  private void sendmessage(){
        if (emsg.getText().length()>0){
            msg mssg = new msg();
            mssg.setMessage(emsg.getText().toString());
            mssg.setTimeStamp(System.currentTimeMillis());
            //mssg.setUserName();
           // FirebaseUser user = firebaseAuth.getCurrentUser();
            mssg.setUserName(mUsername);
            FirebaseDatabase.getInstance().getReference().child("messages").push().setValue(mssg);
            emsg.setText("");
            mListmessage.scrollToPosition(mAdapter.getItemCount()-1);
        }
    }*/
    @Override
    public void onClick(View v) {
        if (msg_btn == v){
            //sendmessage();
        }

    }
}