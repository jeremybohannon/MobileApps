package com.example.android.gettingdatajson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL = "https://rss.itunes.apple.com/api/v1/us/ios-apps/top-grossing/all/25/explicit.json";

        new GetDataJSON(this).execute(URL);
    }

    public void handleData(ArrayList<App> apps){
        for (int i = 0; i < apps.size(); i++) {
            System.out.println(apps.get(i).getArtistName());
        }
    }

}
