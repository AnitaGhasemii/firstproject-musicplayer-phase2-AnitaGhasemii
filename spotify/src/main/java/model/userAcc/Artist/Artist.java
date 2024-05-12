package model.userAcc.Artist;

import model.userAcc.User;

import java.util.ArrayList;

public class Artist  extends User

{
    public static Artist getMainArtist() {
        return mainArtist;
    }

    public static void setMainArtist(Artist amainArtist) {
        mainArtist = amainArtist;
    }

    private static Artist mainArtist;
    private double income;
    private ArrayList<User> followers=new ArrayList<User>();
    private String biography;




    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(User followers) {
        this.followers.add(followers);
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Artist(String userName, String password, String nameAndFamily, String email, String phoneNumber, String birthday, String biography) {
        super(userName, password, nameAndFamily, email, phoneNumber,birthday);

        this.biography = biography;
    }


}
