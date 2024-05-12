package controller.user;

import model.DataBase;
import model.userAcc.User;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    public static boolean checkEmail(String email) {

        String regexEmail = "^\\w+@\\w+\\.com$";

        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(email);
        if (matcherEmail.matches()) {
            return true;
        } else {
            return false;
        }



    }



    public static boolean checkPhoneNumber(String phoneNumber) {
        String regexPhoneNumber = "^09\\d{9}$";
        Pattern patternPhoneNumber = Pattern.compile(regexPhoneNumber);
        Matcher matcherPhoneNumber = patternPhoneNumber.matcher(phoneNumber);
        if (matcherPhoneNumber.matches()) {
            return true;
        } else {
            return false;
        }

    }
    public static boolean findUser(String user) {
        for (User a : DataBase.getDataBase().getUsers()) {
            if (Objects.equals(user, a.getUserName())) {
                return true;
            }
        }
        return false;

    }
}

