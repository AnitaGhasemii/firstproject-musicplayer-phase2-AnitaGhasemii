package controller.user;


import model.exception.FreeAccountLimitException;
import model.*;
import model.audio.Audio;
import model.audio.Music;
import model.exception.LowCreditException;
import model.userAcc.Artist.Artist;
import model.userAcc.Listener.Free;
import model.userAcc.Listener.Listener;
import model.userAcc.Listener.Premium;
import model.userAcc.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;


public class ListenerControl {
    private static ListenerControl listenerControlInstance;

    public static ListenerControl getListenerControlInstance() {
        if (listenerControlInstance == null) {
            listenerControlInstance = new ListenerControl();
        }
        return listenerControlInstance;
    }

    public String likeMusic(String musicId) {
        for (Audio songID : DataBase.getDataBase().getAudios()) {
            if (songID.getID() == Integer.valueOf(musicId)) {
                songID.setNumberOfLikes(songID.getNumberOfLikes() + 1);
            }
        }
        return "the song has been liked";
    }

    public String addGenre(ArrayList<Genre> allGenres) {
        Genre[] genre = new Genre[4];
        int i = 0;
        for (Genre ag : allGenres) {
            genre[i] = ag;
            i++;
        }


        Listener.getListener().setFavoriteGenre(genre);
        return "all genre is added";
    }

    public String reportArtist(String reportData,Artist artist) {
        for (User reportedArtist : DataBase.getDataBase().getUsers()) {
            if (Objects.equals(reportedArtist.getNameAndFamily(), artist.getNameAndFamily())) {
                Report newReport = new Report(model.userAcc.Listener.Listener.getListener(), (Artist) reportedArtist,reportData);
                DataBase.getDataBase().setReports(newReport);
                return "report recorded";
            }
        }
        return "";

    }

    public String increaseCredit(String money) {
        String[] moneyData = money.split("-");
        model.userAcc.Listener.Listener.getListener().setAccountCredit(model.userAcc.Listener.Listener.getListener().
                getAccountCredit() + Integer.valueOf(moneyData[1]));
        return "your credit has been increased";
    }


    public String newPlaylist(String PlaylistData) throws FreeAccountLimitException {

        if (Listener.getListener() instanceof Free) {
            return newPlaylist((Free) Listener.getListener(), PlaylistData);
        }
        if (model.userAcc.Listener.Listener.getListener() instanceof Premium) {
            return newPlaylist((Premium) Listener.getListener(), PlaylistData);
        }
        return "";
    }

    public String newPlaylist(Free listener, String PlaylistData) throws FreeAccountLimitException {
        // String[] PlaylistsDataFr = PlaylistData.split("-");

        if (((Free) Listener.getListener()).getCountPlaylist() <= ((Free) Listener.getListener()).getAddPlaylistLimit()) {
            Listener.getListener().setPlaylists(new Playlist(PlaylistData, Listener.getListener().getNameAndFamily()));
            ((Free) Listener.getListener()).setCountPlaylist(((Free) Listener.getListener()).getCountPlaylist() + 1);
            return "new play list added";
        } else {
            throw new FreeAccountLimitException();
            //return "maximum number of play lists (3) reached";
        }
    }

    public String newPlaylist(Premium listener, String PlaylistData) {
        //String[] PlaylistsDataPr = PlaylistData.split("-");
        Listener.getListener().setPlaylists(new Playlist(PlaylistData, Listener.getListener().getNameAndFamily()));
        return "new play list added";

    }

    public String addMusicToPlayList(String MusicToPlayList) throws FreeAccountLimitException {

        if (Listener.getListener() instanceof Free) {
            return addMusicToPlayList((Free) Listener.getListener(), MusicToPlayList);
        }
        if (model.userAcc.Listener.Listener.getListener() instanceof Premium) {
            return addMusicToPlayList((Premium) Listener.getListener(), MusicToPlayList);
        }
        return "";
    }

    public String addMusicToPlayList(Free listener, String MusicToPlayList) throws FreeAccountLimitException {
        String[] MusicToPlayListDataFr = MusicToPlayList.split("-");
        for (Playlist playlistName : Listener.getListener().getPlaylists()) {
            if (Objects.equals(playlistName.getPlaylistName(), MusicToPlayListDataFr[1])) {
                if (playlistName.getAudios().size() < ((Free) Listener.getListener()).getAddMusicLimit()) {
                    for (Audio track : DataBase.getDataBase().getAudios()) {
                        if (track.getID() == Integer.valueOf(MusicToPlayListDataFr[2])) {
                            playlistName.setAudios(track);
                            return "track successfully added to play list";
                        }
                    }
                } else {
                    throw new FreeAccountLimitException();
                    // return "you've reached the limit of adding tracks to this play list(10)";
                }
            }
        }
        return "";

    }

    public String addMusicToPlayList(Premium listener, String MusicToPlayList) {
        String[] MusicToPlayListDataPr = MusicToPlayList.split("-");
        for (Playlist playlistName : Listener.getListener().getPlaylists()) {
            if (Objects.equals(playlistName.getPlaylistName(), MusicToPlayListDataPr[1])) {
                for (Audio track : DataBase.getDataBase().getAudios()) {
                    if (track.getID() == Integer.valueOf(MusicToPlayListDataPr[2])) {
                        playlistName.setAudios(track);
                        return "track successfully added to play list";
                    }
                }
            }
        }
        return "";


    }


    public String playMusic(String playMusic) {
        String[] playMusicData = playMusic.split("-");
        for (Audio audioId : DataBase.getDataBase().getAudios()) {
            if (audioId.getID() == Integer.valueOf(playMusicData[1])) {
                Listener.getListener().getPlayCount().replace(audioId, (Listener.getListener().getPlayCount().get(audioId) + 1));
                return audioId.toString();
            }
        }
        return "";
    }

    public String followArtist(Artist artist) {
        if (!Listener.getListener().getFollowing().contains(artist)) {
            (artist).setFollowers(Listener.getListener());
            Listener.getListener().setFollowing(artist);
            return "followed";
        }
        return "not followed";


    }

    public String filterAudio(String filterAudio) {
        String[] filterAudioData = filterAudio.split("-");
        StringBuilder filterSb = new StringBuilder();
        if (Objects.equals(filterAudioData[1], "A")) {
            for (User artist : DataBase.getDataBase().getUsers()) {
                if (artist instanceof Artist && Objects.equals(((User) artist).getUserName(), filterAudioData[2])) {
                    for (Audio audio : DataBase.getDataBase().getAudios()) {
                        if (Objects.equals(audio.getArtistName(), artist.getNameAndFamily())) {
                            filterSb.append(audio);
                            filterSb.append("\t");
                        }
                    }

                }
            }

        }
        if (Objects.equals(filterAudioData[1], "G")) {
            for (Audio audio : DataBase.getDataBase().getAudios()) {
                if (Objects.equals(audio.getGenre().toString(), filterAudioData[2])) {
                    filterSb.append(audio.toString());
                    filterSb.append("\t");
                }
            }
        }
        if (Objects.equals(filterAudioData[1], "D")) {
            for (Audio audio : DataBase.getDataBase().getAudios()) {
                if (Objects.equals(audio.getReleaseDate().toString(), filterAudioData[2])) {
                    filterSb.append(audio.toString());
                    filterSb.append("\t");
                }
            }


        }
        return filterSb.toString();


    }

    public String search(String search) {
        String[] searchData = search.split("-");

        StringBuilder searchSb = new StringBuilder();
        for (Audio audio : DataBase.getDataBase().getAudios()) {
            if (Objects.equals(audio.getName(), searchData[1])) {

                searchSb.append("audio: " + audio);
            }
        }

        for (User artist : DataBase.getDataBase().getUsers()) {
            if (Objects.equals(artist.getNameAndFamily(), searchData[1])) {
                searchSb.append("artist : " + artist);
                searchSb.append("biography : " + ((Artist) artist).getBiography());
            }
        }
        return searchSb.toString();


    }


    public String showFollowing() {
        StringBuilder following = new StringBuilder();
        for (User artist : Listener.getListener().getFollowing()) {
            following.append(artist.getNameAndFamily() + "\t");

        }
        return following.toString();
    }

    public ArrayList<User> showArtists() {
        ArrayList<User> artists = new ArrayList<>();
        for (User artist : DataBase.getDataBase().getUsers()) {
            if (artist instanceof Artist) {
                artists.add(artist);
            }

        }
        return artists;
    }

    public String ArtistData(String artistD) {
        String[] artistData = artistD.split("-");
        StringBuilder ArtistSb = new StringBuilder();
        for (User artist : DataBase.getDataBase().getUsers()) {
            if (Objects.equals(artist.getNameAndFamily(), artistData[1])) {
                ArtistSb.append("artist : " + artist);
                ArtistSb.append("biography : " + ((Artist) artist).getBiography() + "" + "\t");
                for (Audio audio : DataBase.getDataBase().getAudios()) {
                    if ((Objects.equals(audio.getArtistName(), artistData[1]))) {
                        ArtistSb.append(audio.getName());
                    }

                }
            }
        }
        return ArtistSb.toString();
    }

    public String showPlaylist() {
        StringBuilder playlist = new StringBuilder();
        for (Playlist playlistName : Listener.getListener().getPlaylists()) {
            playlist.append(playlistName.getPlaylistName() + "\t");

        }
        return playlist.toString();
    }

    public String SelectPlaylist(String playlist) {
        String[] playlistData = playlist.split("-");
        StringBuilder playlistDataSb = new StringBuilder();
        for (Playlist playlistName : Listener.getListener().getPlaylists()) {
            if (Objects.equals(playlistName.getPlaylistName(), playlistData[1])) {
                for (Audio playlistAudio : playlistName.getAudios()) {
                    playlistDataSb.append(playlistAudio.getName());
                }
            }


        }
        return playlist.toString();
    }

    public String lyric(String audio) {
        String[] audioData = audio.split("-");
        for (Audio findAudio : DataBase.getDataBase().getAudios()) {
            if (Objects.equals(findAudio.getID(), audioData[1])) {
                return ((Music) findAudio).getLyrics();

            }
        }
        return "";
    }


    public String getPremium(PremiumSubscriptionPackages subscriptionPackages) throws LowCreditException {
        if (subscriptionPackages == PremiumSubscriptionPackages.sixMonths) {
            if (Listener.getListener() instanceof Free) {
                if (Listener.getListener().getAccountCredit() >=
                        PremiumSubscriptionPackages.sixMonths.getMoney()) {
                    Listener.getListener().setAccountCredit(Listener.getListener().getAccountCredit() -
                            PremiumSubscriptionPackages.sixMonths.getMoney());
                    Premium premium = new Premium(Listener.getListener().getUserName(), Listener.getListener().getPassword(), Listener.getListener().getNameAndFamily(),
                            Listener.getListener().getEmail(), Listener.getListener().getPhoneNumber(), Listener.getListener().getBirthday());
                    DataBase.getDataBase().getUsers().set(DataBase.getDataBase().getUsers().indexOf(Listener.getListener()), premium);
                    premiumTime(premium, 180);
                    premium.setExpirationDate(LocalDate.now().plusDays(180));
                    return "your account is premium now";
                } else {
                    throw new LowCreditException();
                }
            }
            if (subscriptionPackages == PremiumSubscriptionPackages.oneMonth) {
                if (Listener.getListener().getAccountCredit() >=
                        PremiumSubscriptionPackages.oneMonth.getMoney()) {
                    Listener.getListener().setAccountCredit(Listener.getListener().getAccountCredit() -
                            PremiumSubscriptionPackages.oneMonth.getMoney());
                    Premium premium = new Premium(Listener.getListener().getUserName(), Listener.getListener().getPassword(), Listener.getListener().getNameAndFamily(),
                            Listener.getListener().getEmail(), Listener.getListener().getPhoneNumber(), Listener.getListener().getBirthday());
                    DataBase.getDataBase().getUsers().set(DataBase.getDataBase().getUsers().indexOf(Listener.getListener()), premium);
                    premiumTime(premium, 30);
                    premium.setExpirationDate(LocalDate.now().plusDays(30));
                    return "your account is premium now";
                } else {
                    throw new LowCreditException();
                }
            }

            if (subscriptionPackages == PremiumSubscriptionPackages.twoMonths) {
                if (Listener.getListener().getAccountCredit() >=
                        PremiumSubscriptionPackages.twoMonths.getMoney()) {
                    Listener.getListener().setAccountCredit(Listener.getListener().getAccountCredit() -
                            PremiumSubscriptionPackages.twoMonths.getMoney());
                    Premium premium = new Premium(Listener.getListener().getUserName(), Listener.getListener().getPassword(), Listener.getListener().getNameAndFamily(),
                            Listener.getListener().getEmail(), Listener.getListener().getPhoneNumber(), Listener.getListener().getBirthday());
                    DataBase.getDataBase().getUsers().set(DataBase.getDataBase().getUsers().indexOf(Listener.getListener()), premium);
                    premiumTime(premium, 60);
                    premium.setExpirationDate(LocalDate.now().plusDays(60));
                    return "your account is premium now";
                } else {
                    throw new LowCreditException();
                }

            }
        }


        if ((Listener.getListener() instanceof Premium)) {
            if (Listener.getListener().getAccountCredit() >=
                    PremiumSubscriptionPackages.sixMonths.getMoney()) {
                Listener.getListener().setAccountCredit(Listener.getListener().getAccountCredit() -
                        PremiumSubscriptionPackages.sixMonths.getMoney());
                premiumTime((Premium) Premium.getListener(), 180);
                ((Premium) Listener.getListener()).setLeftSubscription(((Premium) Listener.getListener()).getLeftSubscription() + 180);

                return "new package purchased";
            } else {
                throw new LowCreditException();
            }
        }
        if (subscriptionPackages == PremiumSubscriptionPackages.oneMonth) {
            if (Listener.getListener().getAccountCredit() >=
                    PremiumSubscriptionPackages.oneMonth.getMoney()) {
                Listener.getListener().setAccountCredit(Listener.getListener().getAccountCredit() -
                        PremiumSubscriptionPackages.oneMonth.getMoney());
                premiumTime((Premium) Premium.getListener(), 30);
                ((Premium) Listener.getListener()).setLeftSubscription(((Premium) Listener.getListener()).getLeftSubscription() + 30);
                return "new package purchased";
            } else {
                throw new LowCreditException();
            }
        }

        if (subscriptionPackages == PremiumSubscriptionPackages.twoMonths) {
            if (Listener.getListener().getAccountCredit() >=
                    PremiumSubscriptionPackages.twoMonths.getMoney()) {
                Listener.getListener().setAccountCredit(Listener.getListener().getAccountCredit() -
                        PremiumSubscriptionPackages.twoMonths.getMoney());
                premiumTime((Premium) Premium.getListener(), 60);
                ((Premium) Listener.getListener()).setLeftSubscription(((
                        Premium) Listener.getListener()).getLeftSubscription() + 60);
                return "new package purchased";
            } else {
                throw new LowCreditException();
            }


        }
        return "";

    }

    public boolean playListAvailable(String namePlayList) {
        for (Playlist PL : Listener.getListener().getPlaylists()) {

            if (PL.getPlaylistName().equals(namePlayList)) {
                return true;
            }

        }
        return false;
    }

    public void premiumTime(Premium listener, int day) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int countDay = day;

            @Override
            public void run() {
                countDay--;
                ((Premium) Listener.getListener()).setLeftSubscription(countDay);
                if (countDay == 0) {
                    DataBase.getDataBase().getUsers().set(DataBase.getDataBase().getUsers().indexOf(listener),
                            new Free(Listener.getListener().getUserName(), Listener.getListener().getPassword()
                                    , Listener.getListener().getNameAndFamily(), Listener.getListener().getEmail()
                                    , Listener.getListener().getPhoneNumber(), Listener.getListener().getBirthday()));
                    listener.setLeftSubscription(0);

                }

            }
        };
        timer.schedule(task, 86400000, 86400000);
    }


}
