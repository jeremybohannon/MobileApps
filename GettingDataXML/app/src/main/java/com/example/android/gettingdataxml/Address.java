package com.example.android.gettingdataxml;

/**
 * Created by jeremybohannon on 10/16/17.
 */

public class Address {
    String line1;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                '}';
    }
}
