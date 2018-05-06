package com.example.mhodinshamadari.gpslocationfortravellers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mhodinshamadari on 22-04-2018.
 */

public class Location extends AppCompatActivity implements View.OnClickListener, LocationListener {

    TextView loc;
    TextView lng;
    EditText username;
    Button my_loc;
    private DatabaseReference databaseReference;
    private FirebaseAuth user;
    private FirebaseAuth mAuth;
    private LocationManager locationManager;
    private LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_location);

        username = findViewById(R.id.feed);
        my_loc = findViewById(R.id.my_loc);
        loc = findViewById(R.id.loc);
        lng = findViewById(R.id.lng);
        my_loc.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
         locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,0,this);


        }

    @Override
    public void onLocationChanged(android.location.Location location) {
        double longitude = location.getLongitude();
        double lattitude = location.getLatitude();
        loc.setText(""+ lattitude);
        lng.setText(""+ longitude);
        if (location!=null){
            srloc();
        }
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    public void srloc(){
       // final String lattitude = loc.getText().toString().trim();
       // String name = username.getText().toString().trim();
        //String val = "users";
        double lattitude= Double.parseDouble(loc.getText().toString().trim());
        double longitude= Double.parseDouble(lng.getText().toString().trim());
        // String longitude = lat.getText().toString().trim();
       //final DatabaseReference locRef = FirebaseDatabase.getInstance().getReference(name"/"val);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        User myuser =new User();
        //DatabaseReference newRef =databaseReference.child(user.getPhoneNumber());
        databaseReference.child(user.getPhoneNumber()).child("lat").setValue(lattitude);
        databaseReference.child(user.getPhoneNumber()).child("lng").setValue(longitude);










    }

    @Override
    public void onClick(View v) {
        if( v == my_loc){
            srloc();
        }
        startActivity(new Intent(getApplicationContext(),BottomActivity.class));
    }


}


