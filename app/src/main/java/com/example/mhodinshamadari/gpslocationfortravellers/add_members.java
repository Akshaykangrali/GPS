package com.example.mhodinshamadari.gpslocationfortravellers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhodinshamadari on 14-04-2018.
 */

public class add_members extends AppCompatActivity  {

     ListView listviewaddmembers;
    DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mUserDatabaseReference;
    private DatabaseReference mCurrentUsersFriends;
    private FirebaseAuth mFirebaseAuth;


    //  public ArrayList<String> arraylist = new ArrayList<>();
   // public ArrayAdapter<String> adapter;
    User user;
    List<User> memberlist;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_members);

        listviewaddmembers  = findViewById(R.id.listviewaddmembers);
        user = new User();
        memberlist = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                memberlist.clear();
                for(DataSnapshot usersnapshot : dataSnapshot.getChildren()){
                    User users = usersnapshot.getValue(User.class);
                    FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                    memberlist.add(users);

                }

                addlist adapter = new addlist(add_members.this,memberlist);
                listviewaddmembers.setAdapter(adapter);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listviewaddmembers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
               // Toast.makeText(add_members.this, "get", Toast.LENGTH_SHORT).show();
               // addlist adapter = new addlist(add_members.this,memberlist);
                String main =listviewaddmembers.getSelectedItem().toString();
                databaseReference = FirebaseDatabase.getInstance().getReference("friends");
                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                databaseReference.child(main).setValue(main);
                Toast.makeText(add_members.this, "added", Toast.LENGTH_SHORT).show();

            }
        });


    }
/*@Override
    protected void onStart(){
        super.onStart();


}*/

   /* public int getCount(){
        return memberlist.size();
}
public Object getItem(int location){
        return memberlist.get(location);
}

public  long getItemId(int position){
    return position;
}*/


   /* private void addNewFriend(String newFriendEmail){
        //Get current user logged in by email
        final String userLoggedIn = firebaseAuth.getCurrentUser().getPhoneNumber();
        Log.e(TAG, "User logged in is: " + userLoggedIn);
        //final String newFriendEncodedEmail = EmailEncoding.commaEncodePeriod(newFriendEmail);
        final DatabaseReference friendsRef = mFirebaseDatabase.getReference(Constants.FRIENDS_LOCATION
                + "/" + EmailEncoding.commaEncodePeriod(userLoggedIn));
        //Add friends to current users friends list
        friendsRef.child(newFriendEmail).setValue(newFriendEmail);
    }

    private void removeFriend(String friendEmail){
        //Get current user logged in by email
        final String userLoggedIn = mFirebaseAuth.getCurrentUser().getEmail();
        Log.e(TAG, "User logged in is: " + userLoggedIn);
        final DatabaseReference friendsRef = mFirebaseDatabase.getReference(Constants.FRIENDS_LOCATION
                + "/" + EmailEncoding.commaEncodePeriod(userLoggedIn));
        friendsRef.child(EmailEncoding.commaEncodePeriod(friendEmail)).removeValue();
    }
*/

}
