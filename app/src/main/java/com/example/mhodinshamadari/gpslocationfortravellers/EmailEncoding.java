package com.example.mhodinshamadari.gpslocationfortravellers;

/**
 * Created by mhodinshamadari on 21-04-2018.
 */

public class EmailEncoding {
    public static String commaEncodePeriod(String email) {
        return email.replace(".", ",");
    }

    public static String commaDecodePeriod(String email) {
        return email.replace(",", ".");
    }
}
