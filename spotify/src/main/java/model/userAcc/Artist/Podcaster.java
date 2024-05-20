package model.userAcc.Artist;

import model.audio.Podcast;
import model.userAcc.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class Podcaster  extends Artist{
    private ArrayList<Podcast> podcasts=new ArrayList<>() ;

    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(Podcast podcasts) {
        this.podcasts.add(podcasts);
    }

    public Podcaster(String userName, String password, String nameAndFamily, String email, String phoneNumber, LocalDate birthday, String biography) {
        super(userName, password, nameAndFamily, email, phoneNumber,birthday, biography);

    }
}
