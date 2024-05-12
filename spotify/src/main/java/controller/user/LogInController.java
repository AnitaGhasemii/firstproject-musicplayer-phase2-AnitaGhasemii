package controller.user;

import model.DataBase;
import model.userAcc.Admin;
import model.userAcc.Artist.Artist;
import model.userAcc.Listener.Listener;
import model.userAcc.User;

import java.util.Objects;

public class LogInController {
    private static LogInController logInControllerInstance;
    public static LogInController getlogInControllerInstance() {
        if(logInControllerInstance==null) {
            logInControllerInstance = new LogInController();
        }
        return logInControllerInstance;
    }
    public String logIn(String user, String pass) {
        for (User userlogIn : DataBase.getDataBase().getUsers()) {
            if (Objects.equals(user, userlogIn.getUserName())) {
                if (Objects.equals(pass, userlogIn.getPassword())) {
                    if (userlogIn instanceof Artist) {
                        Artist.setMainArtist((Artist) userlogIn);
                        return "dear Artist welcome!";
                    }
                    if (userlogIn instanceof Admin) {
                        Admin.setAdmin((Admin) userlogIn);
                        return "dear Admin welcome!";
                    }
                    if (userlogIn instanceof Listener) {
                        Listener.setListener((Listener) userlogIn);
                        return "dear Listener welcome!";
                    }
                } else {
                   // return "Your password is incorrect";
                }
            } else {
                //return "Username does not exist";
            }
        }
        return "username or password is wrong";

    }

}
