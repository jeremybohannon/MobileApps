package com.example.android.Listview;

/**
 * Created by jeremybohannon on 10/15/17.
 */

public class DataObject {
    private String name;
    private String price;
    private int picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public DataObject(String name, String price, int picture) {

        this.name = name;
        this.price = price;
        this.picture = picture;
    }
}
