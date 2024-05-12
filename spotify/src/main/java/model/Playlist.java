package model;

import model.audio.Audio;

import java.util.ArrayList;

public class Playlist {
    private int playlistID;
    private String playlistName;
    private String user;
    private ArrayList<Audio> audios=new ArrayList<>();

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(Audio audios) {
        this.audios.add(audios);
    }
    private int playlistIdCount=1;

    public int getPlaylistIdCount() {
        return playlistIdCount;
    }

    public void setPlaylistIdCount(int playlistIdCount) {
        this.playlistIdCount = playlistIdCount;
    }

    public Playlist(String playlistName, String user) {
        this.playlistName=playlistName;
        this.playlistID = playlistIdCount;
        playlistIdCount++;
        this.user = user;


    }
}
