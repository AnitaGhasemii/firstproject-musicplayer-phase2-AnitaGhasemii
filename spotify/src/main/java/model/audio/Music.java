package model.audio;

import model.Genre;

public class Music extends Audio {
    private String lyrics;

    public Music(String name, String artistName, Genre genre, String audioLink, String cover,String lyrics) {
        super(name, artistName, genre, audioLink, cover);
        this.lyrics=lyrics;

    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }


}
