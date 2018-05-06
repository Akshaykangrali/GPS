package com.example.mhodinshamadari.gpslocationfortravellers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        LocationListener,GoogleMap.OnMarkerClickListener{
    private  GoogleMap mMap;
    private ChildEventListener mChildEventListener;
    private DatabaseReference mUser;
    Marker marker;
    User user;
    private LocationManager locationManager;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ChildEventListener mChildEventListener;
        mUser = FirebaseDatabase.getInstance().getReference("users");
        mUser.push().setValue(marker);

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
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,500,0,this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setOnMarkerClickListener(this);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot s : dataSnapshot.getChildren()){
                    user = s.getValue(User.class);
                    LatLng location =  new LatLng(user.lat,user.lng);
                    mMap.addMarker(new MarkerOptions().position(location).title(user.username)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    @Override
    public void onLocationChanged(Location location) {
        double longitude = location.getLongitude();
        double lattitude = location.getLatitude();
//        loc.setText(""+ lattitude);
//        lng.setText(""+ longitude);
        if (location!=null){
            srloc(lattitude,longitude);
        }
        //mUser = location;
//        if (marker != null) {
//            marker.remove();
//        }
//
//        //Place current location marker
//        LatLng latLng =  new LatLng(user.lat,user.lng);
//        mMap.addMarker(new MarkerOptions().position(latLng).title(user.username)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
//
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(latLng);
//        markerOptions.title("Current Position");
//        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
//        marker = mMap.addMarker(markerOptions);
//
//        //move map camera
////        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,11));
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,11));
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

    public void srloc(double lat,double lng){
        // final String lattitude = loc.getText().toString().trim();
        // String name = username.getText().toString().trim();
        //String val = "users";
        // String longitude = lat.getText().toString().trim();
        //final DatabaseReference locRef = FirebaseDatabase.getInstance().getReference(name"/"val);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        User myuser =new User();
        //DatabaseReference newRef =databaseReference.child(user.getPhoneNumber());
        try {
            mUser.child(user.getPhoneNumber()).child("lat").setValue(lat);
            mUser.child(user.getPhoneNumber()).child("lng").setValue(lng);
            Toast.makeText(this, "Lat: "+lat+"Lang: "+lng, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}