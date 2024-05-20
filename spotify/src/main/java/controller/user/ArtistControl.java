package controller.user;
import model.Album;
import model.DataBase;
import model.Genre;
import model.audio.Audio;
import model.audio.Music;
import model.audio.Podcast;
import model.exception.FailedLogInException.UserNotFoundException;
import model.exception.InvalidFormatException;
import model.userAcc.Artist.Artist;
import model.userAcc.Artist.Podcaster;
import model.userAcc.Artist.Singer;
import model.userAcc.User;

import java.util.Objects;

import static controller.user.Checker.*;

public class ArtistControl {
    private static ArtistControl artistControlInstance;
    public static ArtistControl getArtistControlInstance() {
        if(artistControlInstance==null) {
            artistControlInstance = new ArtistControl();
        }
        return artistControlInstance;
    }



    public String showFollowers() {
        StringBuilder sbFollowers = new StringBuilder("");
        for (User follower : model.userAcc.Artist.Artist.getMainArtist().getFollowers()) {
            sbFollowers.append(follower.getUserName());
            sbFollowers.append("\t");


        }
        return sbFollowers.toString();
    }


    public String showPlayCount() {

        if (model.userAcc.Artist.Artist.getMainArtist() instanceof Singer) {
            StringBuilder sbPlayCountMusics = new StringBuilder("");
            for (Album album : ((Singer) Artist.getMainArtist()).getAlbums()) {
                for (Audio audio : album.getMusics()) {
                    sbPlayCountMusics.append(audio.getName());
                    sbPlayCountMusics.append(": ");
                    sbPlayCountMusics.append(audio.getNumberOfPlays());
                    sbPlayCountMusics.append("\t");
                }
            }
            return sbPlayCountMusics.toString();


        }
        if (model.userAcc.Artist.Artist.getMainArtist() instanceof Podcaster) {
            StringBuilder sbPlayCountPodcast = new StringBuilder("");
            for (Podcast podcast : ((Podcaster) Artist.getMainArtist()).getPodcasts()) {

                sbPlayCountPodcast.append(podcast.getName());
                sbPlayCountPodcast.append(": ");
                sbPlayCountPodcast.append(podcast.getNumberOfPlays());
                sbPlayCountPodcast.append("\t");

            }
            return sbPlayCountPodcast.toString();


        }
        return "";

    }

    public String showUserInfo() {
        return model.userAcc.Artist.Artist.getMainArtist().toString();
    }

    public String publishType(String publish){
        String[] publishData = publish.split("-");
        if(Objects.equals(publishData[1], "M")){
            return publishMusic(publish);
        }
        if(Objects.equals(publishData[1], "P")){
            return publishPodcast(publish);
        }
        return "";

    }

    public String publishMusic(String newMusicData) {
        String[] newMusicsData = newMusicData.split("-");
        Music newmusic = new Music(newMusicsData[2], model.userAcc.Artist.Artist.getMainArtist().getNameAndFamily(),
                Genre.valueOf(newMusicsData[3]), newMusicsData[5], newMusicsData[6], newMusicsData[4]);
        DataBase.getDataBase().setAudios(newmusic);
        for (Album albumId : ((Singer) Artist.getMainArtist()).getAlbums()) {
            if (albumId.getAlbumID() == Integer.valueOf(newMusicsData[7])) {
                albumId.setMusics(newmusic);
            }
        }
        return "new music successfully added";

    }
    public String publishPodcast(String newPodcastData) {
        String[] newPodcastsData = newPodcastData.split("-");
       Podcast newpodcast = new Podcast(newPodcastsData[2], model.userAcc.Artist.Artist.getMainArtist().getNameAndFamily(),
                Genre.valueOf(newPodcastsData[3]), newPodcastsData[5], newPodcastsData[6], newPodcastsData[4]);
        DataBase.getDataBase().setAudios(newpodcast);
        ((Podcaster) Artist.getMainArtist()).setPodcasts(newpodcast);

        return "new podcast successfully added";

    }

    public String newAlbum(String albumName){
        String[] newAlbumData=albumName.split("-");
        Album newAlbum=new Album(newAlbumData[1],model.userAcc.Artist.Artist.getMainArtist().getNameAndFamily());
        ((Singer)Artist.getMainArtist()).setAlbums(newAlbum);
        return "new album successfully added";

    }
    public Double calculateEarnings() {
        int count = 0;
        for (Audio audio : DataBase.getDataBase().getAudios()) {
            if (Objects.equals(audio.getArtistName(), Artist.getMainArtist().getNameAndFamily())) {
                count = count + audio.getNumberOfPlays();
            }
        }
        if (Artist.getMainArtist() instanceof Singer) {
            Artist.getMainArtist().setIncome(count * 0.4);

        }
        if (Artist.getMainArtist() instanceof Podcaster) {
            Artist.getMainArtist().setIncome(count * 0.5);

        }
        return Artist.getMainArtist().getIncome();
    }

    public  void calculateEarningsUpdate() {
        int count = 0;
        for (Audio audio : DataBase.getDataBase().getAudios()) {
            if (Objects.equals(audio.getArtistName(), Artist.getMainArtist().getNameAndFamily())) {
                count = count + audio.getNumberOfPlays();
            }
        }
        if (Artist.getMainArtist() instanceof Singer) {
            Artist.getMainArtist().setIncome(count * 0.4);

        }
        if (Artist.getMainArtist() instanceof Podcaster) {
            Artist.getMainArtist().setIncome(count * 0.5);

        }

    }








}




























