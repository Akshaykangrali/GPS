package com.example.mhodinshamadari.gpslocationfortravellers.Messages;

/**
 * Created by mhodinshamadari on 23-04-2018.
 */

public class msg {
    private String userName;
    private String message;
    long  timeStamp;

    public msg() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
