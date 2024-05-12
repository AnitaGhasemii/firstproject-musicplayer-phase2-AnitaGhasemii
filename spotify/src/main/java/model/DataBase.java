package model;

import model.audio.Audio;
import model.userAcc.Admin;
import model.userAcc.User;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<Report> reports;
    private static DataBase dataBase;
    public DataBase() {
       this.users=new ArrayList<User>();
       this.audios=new ArrayList<Audio>();
       this.reports =new ArrayList<Report>();
    }


    public static DataBase getDataBase() {
        if (dataBase == null) {
            dataBase = new DataBase();
            return dataBase;
        } else {
            return dataBase;
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public void setUsers(User users) {
        this.users.add(users);
    }
    public ArrayList<Audio> getAudios() {
        return audios;
    }
    public void setAudios(Audio audios) {
        this.audios.add(audios);
    }
    public ArrayList<Report> getReports() {
        return reports;
    }
    public void setReports(Report reports) {
        this.reports.add(reports);
    }


}
