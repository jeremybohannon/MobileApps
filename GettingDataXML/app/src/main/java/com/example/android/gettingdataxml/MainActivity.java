package com.example.android.gettingdataxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL = "http://api.theappsdr.com/xml/";

        new GetDataXML(this).execute(URL);
    }
}
