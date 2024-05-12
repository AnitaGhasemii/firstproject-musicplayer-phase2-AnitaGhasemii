package model.userAcc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class User {
    private int ID;
    //private static String userName;
    private  String userName;
    private String password;
    private String nameAndFamily;
    private String email;
    private String phoneNumber;
    private LocalDate birthday;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public  String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameAndFamily() {
        return nameAndFamily;
    }

    public void setNameAndFamily(String nameAndFamily) {
        this.nameAndFamily = nameAndFamily;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getIDcount() {
        return IDcount;
    }

    public void setIDcount(int IDcount) {
        this.IDcount = IDcount;
    }

   static int IDcount=1;

    public User( String userName, String password, String nameAndFamily, String email, String phoneNumber,String birthday) {
        DateTimeFormatter birth= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ID = IDcount;
        IDcount++;
        this.userName = userName;
        this.password = password;
        this.nameAndFamily = nameAndFamily;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = LocalDate.parse(birthday,birth);

    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", password='" + password + '\'' +
                ", nameAndFamily='" + nameAndFamily + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
