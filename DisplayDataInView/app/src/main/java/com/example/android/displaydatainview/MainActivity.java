package com.example.android.displaydatainview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<App> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set URL of API
        String URL = "https://rss.itunes.apple.com/api/v1/us/ios-apps/top-grossing/all/25/explicit.json";

        //Start getting data
        new GetDataJSON(this).execute(URL);
    }

    //Method will set up a list view
    public void setUpListView(){
        lv = (ListView) findViewById(R.id.listView);

        sortApps();
        final CustomAdapter customAdapter = new CustomAdapter(this, R.layout.data_view, apps);
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                int index = i;

                App app = apps.get(i);

                System.out.println("Object: " + app.getArtistName());

                apps.remove(i);

                customAdapter.notifyDataSetChanged();
            }
        });
    }

    public void sortApps(){
        Collections.sort(apps, new CustomComparator());
    }

    public void handleData(ArrayList<App> apps){
        this.apps = apps;
        setUpListView();
    }
}
