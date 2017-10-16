package com.example.android.recycleviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<CustomModel> customModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        customModels.add(new CustomModel("Test"));
        customModels.add(new CustomModel("test2"));
        customModels.add(new CustomModel("Test"));
        customModels.add(new CustomModel("test2"));

        CustomAdapter customAdapter = new CustomAdapter(customModels);

        rv.setAdapter(customAdapter);

    }
}
