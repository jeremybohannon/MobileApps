package com.example.android.Listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<DataObject> objects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);

        objects.add(new DataObject("New Game", "12.99", R.drawable.add_photo));
        objects.add(new DataObject("Cuphead", "30.45", R.drawable.default_image));
        objects.add(new DataObject("Blackops", "79.99", R.drawable.add_photo));

        final CustomAdapter customAdapter = new CustomAdapter(this, R.layout.data_view, objects);
        lv.setAdapter(customAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                int index = i;

                DataObject object = objects.get(i);


                System.out.println("Object: " + object.getName());

                objects.remove(i);

                customAdapter.notifyDataSetChanged();



            }
        });

    }
}
