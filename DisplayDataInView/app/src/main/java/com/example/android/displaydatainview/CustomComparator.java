package com.example.android.displaydatainview;

import java.util.Comparator;

/**
 * Created by jeremybohannon on 10/16/17.
 */

public class CustomComparator implements Comparator<App> {
    @Override
    public int compare(App app, App t1) {
        return app.getArtistName().compareTo(t1.getArtistName());
    }
}
