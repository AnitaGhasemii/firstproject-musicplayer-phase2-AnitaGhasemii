package model.userAcc.Artist;

import model.Album;
import model.userAcc.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class Singer extends Artist {
    private ArrayList<Album> albums=new ArrayList<>();

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Album albums) {
        this.albums.add(albums);
    }


    public Singer(String userName, String password, String nameAndFamily, String email, String phoneNumber, LocalDate birthday, String biography) {
        super(userName, password, nameAndFamily, email, phoneNumber,birthday, biography);

    }
}
