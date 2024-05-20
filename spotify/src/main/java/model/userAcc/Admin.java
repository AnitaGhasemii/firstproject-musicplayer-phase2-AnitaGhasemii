package model.userAcc;

import java.time.LocalDate;

public class Admin extends User {
    private static Admin admin;

    public Admin(String userName, String password, String nameAndFamily, String email, String phoneNumber, LocalDate birthday) {
        super(userName, password, nameAndFamily, email, phoneNumber,birthday);
    }

    public static void setAdmin(Admin admin) {
        Admin.admin = admin;
    }

    private static Admin getAdmin(String userName, String password, String nameAndFamily, String email, String phoneNumber, LocalDate birthday){
        if(admin==null){
            admin=new Admin( userName, password, nameAndFamily,  email, phoneNumber,birthday);
            return admin;
        }
        else {
            return admin;
        }
    }
    public static Admin getAdmin(){
        return admin;}





}
