package com.trendyol.bootcamp.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Track {

    private String trackId;
    private String trackName;
    private String length;
    private String artist;

    public Track(){
        this.trackId = UUID.randomUUID().toString();
    }

    public Track(String trackName, String length, String artist) {
        this.trackId = UUID.randomUUID().toString();
        this.trackName = trackName;
        this.length = length;
        this.artist = artist;
    }

    public Track(String trackId, String trackName, String length, String artist) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.length = length;
        this.artist = artist;
    }
}
