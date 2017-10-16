package com.example.android.gettingdataxml;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jeremybohannon on 10/16/17.
 */

public class GetDataXML extends AsyncTask<String, Void, ArrayList<Person>> {
    private MainActivity activity;

    public GetDataXML(MainActivity activity){
        this.activity = activity;
    }

    @Override
    protected ArrayList<Person> doInBackground(String... strings) {
        HttpURLConnection connection = null;
        ArrayList<Person> result = null;
        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                 result = PersonParser.PersonsSAXParser.parsePersons(connection.getInputStream());
            }
        } catch (Exception e) {
            //Handle the exceptions
        } finally {
            //Close open connections and reader
        }

        return result;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> result) {
        super.onPostExecute(result);

        System.out.println(result);
    }
}
