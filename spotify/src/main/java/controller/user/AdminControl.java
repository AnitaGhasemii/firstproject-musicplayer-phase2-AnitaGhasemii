package controller.user;

import model.DataBase;
import model.Report;
import model.audio.Audio;
import model.userAcc.Artist.Artist;
import model.userAcc.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class AdminControl {
    private static AdminControl adminControlInstance;
    public static AdminControl getAdminControlInstance() {
        if(adminControlInstance==null) {
            adminControlInstance = new AdminControl();
        }
        return adminControlInstance;
    }

    public String showReport() {
        StringBuilder sbReport = new StringBuilder("");

        for (Report report : DataBase.getDataBase().getReports()) {
            sbReport.append("Reporter User: "+report.getReporterUser().getUserName());
            sbReport.append("\t");

            sbReport.append("Reported Artist"+report.getReportedArtist().getUserName());
            sbReport.append("\t");

            sbReport.append("Description"+report.getDescription());
            sbReport.append("\t");
        }
        return sbReport.toString();}

    public String showUserInfoAdmin(){
        return model.userAcc.Admin.getAdmin().toString();
    }


public String showArtistAndAudioInfo() {
    StringBuilder showArtistAndAudioInfo = new StringBuilder("");
    for (Audio AudioInfo: DataBase.getDataBase().getAudios()) {
        showArtistAndAudioInfo.append("Audio: " +AudioInfo.toString()+"\t");
    }
    for (User ArtistInfo: DataBase.getDataBase().getUsers()) {
        if(ArtistInfo instanceof Artist){
        showArtistAndAudioInfo.append("Artist: " +ArtistInfo.toString()+"\t");
        showArtistAndAudioInfo.append("Biography: " +((Artist) ArtistInfo).getBiography()+"\t");}
    }
    return showArtistAndAudioInfo.toString();
}
 public String showFavoriteMusic(){
     StringBuilder sort = new StringBuilder("");
     ArrayList<Integer> like=new ArrayList<>();
     for(Audio audioSort: DataBase.getDataBase().getAudios()){
         like.add(audioSort.getNumberOfLikes());
     }
     Collections.sort(like, Collections.reverseOrder());

     for(int index=0;index<=like.size();index++){
         for (Audio audioSort: DataBase.getDataBase().getAudios()){
             if(audioSort.getNumberOfLikes()==like.get(index)){
                 sort.append((audioSort.getName()+"\t"+audioSort.getNumberOfLikes()));
                 index++;
             }
         }
     }
     return sort.toString();


 }
    public String showArtist() {
        StringBuilder Artist = new StringBuilder();
        for (User artist : DataBase.getDataBase().getUsers()) {
            if (artist instanceof Artist) {
                Artist.append(artist.getNameAndFamily() + "\t");
            }

        }
        return Artist.toString();
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
    public String showAudio() {
        StringBuilder Artist = new StringBuilder();
        for (Audio audio : DataBase.getDataBase().getAudios()) {
                Artist.append(audio.getName() + "\t");


        }
        return Artist.toString();
    }

    public String audioData(String audio) {
        String[] audioData = audio.split("-");
        StringBuilder audioSb = new StringBuilder();
        for (Audio findAudio : DataBase.getDataBase().getAudios()) {
            if (Objects.equals(findAudio.getID(),audioData[1])) {
                audioSb.append("audio: " + audio.toString());
            }
        }
        return audioSb.toString();
    }









}
