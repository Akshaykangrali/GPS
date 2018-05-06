package com.example.mhodinshamadari.gpslocationfortravellers;

/**
 * Created by mhodinshamadari on 22-04-2018.
 */

public class myloc {
    double lat;
    double lon;
    public myloc() {

    }

    public myloc(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
