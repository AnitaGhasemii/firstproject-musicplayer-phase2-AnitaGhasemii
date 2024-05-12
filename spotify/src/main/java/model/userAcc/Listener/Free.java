package model.userAcc.Listener;

import model.Genre;

import java.util.Date;

public class Free extends Listener {
    private final  int addMusicLimit=10;

    public int getAddMusicLimit() {
        return addMusicLimit;
    }

    public int getAddPlaylistLimit() {
        return addPlaylistLimit;
    }

    private final  int addPlaylistLimit=3;
    private int countMusic;
    private int countPlaylist;

    public int getCountMusic() {
        return countMusic;
    }

    public void setCountMusic(int countMusic) {
        this.countMusic = countMusic;
    }

    public int getCountPlaylist() {
        return countPlaylist;
    }

    public void setCountPlaylist(int countPlaylist) {
        this.countPlaylist = countPlaylist;
    }

    public Free(String userName, String password, String nameAndFamily, String email, String phoneNumber, String birthday) {
        super(userName, password, nameAndFamily, email, phoneNumber,birthday);
    }
}
