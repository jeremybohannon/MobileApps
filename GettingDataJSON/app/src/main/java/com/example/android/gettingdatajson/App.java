package com.example.android.gettingdatajson;

/**
 * Created by jeremybohannon on 10/16/17.
 */

public class App {
    private String artistName;
    private String kind;
    private String artworkUrl100;

    public App(String artistName, String kind, String artworkUrl100) {
        this.artistName = artistName;
        this.kind = kind;
        this.artworkUrl100 = artworkUrl100;
    }

    public String getArtistName() {

        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }
}
