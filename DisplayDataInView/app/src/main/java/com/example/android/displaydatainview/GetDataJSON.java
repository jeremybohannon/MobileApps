package com.example.android.displaydatainview;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jeremybohannon on 10/16/17.
 */

public class GetDataJSON extends AsyncTask<String, Void, String> {
    private MainActivity activity;

    ArrayList<App> apps = new ArrayList<>();

    public GetDataJSON(MainActivity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;
        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                result = stringBuilder.toString();
            }
        } catch (Exception e) {
            //Handle the exceptions
        } finally {
            //Close open connections and reader
        }

        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try {
            JSONObject root = new JSONObject(result);
            JSONObject feed = root.getJSONObject("feed");
            JSONArray results = feed.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject resultApp = results.getJSONObject(i);

                String artistName = resultApp.getString("artistName");
                String kind = resultApp.getString("kind");
                String artworkUrl100 = resultApp.getString("artworkUrl100");

                apps.add(new App(artistName, kind, artworkUrl100));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        activity.handleData(apps);
    }
}
