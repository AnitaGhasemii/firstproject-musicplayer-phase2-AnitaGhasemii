package model.audio;

import model.Genre;

public class Podcast extends Audio{
    private String caption;

    public Podcast(String name, String artistName, Genre genre, String audioLink, String cover,String caption) {
        super(name, artistName, genre, audioLink, cover);
        this.caption=caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }


}
