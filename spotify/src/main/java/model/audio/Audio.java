package model.audio;
import model.Genre;

import java.time.LocalDate;
import java.util.Date;

public abstract class Audio {
    @Override
    public String toString() {
        return "Audio{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                ", numberOfPlays=" + numberOfPlays +
                ", numberOfLikes=" + numberOfLikes +
                ", genre=" + genre +
                ", audioLink='" + audioLink + '\'' +
                ", cover='" + cover + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    private int ID;
    private String name;
    private String artistName;
    private int numberOfPlays;
    private int numberOfLikes;
    private Genre genre;
    private String audioLink;
    private String cover;
    private LocalDate releaseDate;
    static int counter=1;


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setNumberOfPlays(int numberOfPlays) {
        this.numberOfPlays = numberOfPlays;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getNumberOfPlays() {
        return numberOfPlays;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public String getCover() {
        return cover;
    }

    public Audio( String name, String artistName, Genre genre, String audioLink, String cover) {
        this.ID = counter;
        counter++;
        this.name = name;
        this.artistName = artistName;
        this.numberOfPlays = 0;
        this.numberOfLikes = 0;
        this.genre = genre;
        this.audioLink = audioLink;
        this.cover = cover;
        this.releaseDate = LocalDate.now();

    }



}
