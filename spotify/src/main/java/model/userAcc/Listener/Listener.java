package model.userAcc.Listener;

import model.Genre;
import model.Playlist;
import model.audio.Audio;
import model.userAcc.Artist.Artist;
import model.userAcc.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Listener extends User {
    private static Listener listener;

    public static Listener getListener() {
        return listener;
    }

    public static void setListener(Listener listener) {
        Listener.listener = listener;
    }

    private int accountCredit;
    private ArrayList<Playlist> playlists=new ArrayList<>();
    private ArrayList <Artist> following=new ArrayList<>();
    private Map<Audio,Integer> playCount;
    private Genre[] favoriteGenre;
    private LocalDate expirationDate;

    public int getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(int accountCredit) {
        this.accountCredit = accountCredit;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist playlists) {
        this.playlists.add(playlists);
    }
    public ArrayList<Artist> getFollowing() {
        return following;
    }

    public void setFollowing(Artist following) {
        this.following.add(following);
    }


    public Map<Audio, Integer> getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Map<Audio, Integer> playCount) {
        this.playCount = playCount;
    }

    public Genre[] getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(Genre[] favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Listener(String userName, String password, String nameAndFamily, String email, String phoneNumber, String birthday) {
        super(userName, password, nameAndFamily, email, phoneNumber,birthday);


    }
}



