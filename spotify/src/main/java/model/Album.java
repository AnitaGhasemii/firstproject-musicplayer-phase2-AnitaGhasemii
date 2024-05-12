package model;

import model.audio.Music;

import java.util.ArrayList;

public class Album {
    private int albumID;
    private String albumName;
    private String artistName;
    private ArrayList<Music> musics=new ArrayList<>();
    private static int albumCount=0;

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }

    public void setMusics(Music musics) {
        this.musics.add( musics);
    }

    public Album( String albumName, String artistName) {
        this.albumID = albumCount;
        albumCount++;
        this.albumName = albumName;
        this.artistName = artistName;


    }
}
