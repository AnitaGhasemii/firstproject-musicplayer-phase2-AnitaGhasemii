package controller.user;
import model.exception.FailedLogInException.UserNotFoundException;
import model.exception.InvalidFormatException;
import model.DataBase;
import model.userAcc.Artist.Artist;
import model.userAcc.Artist.Podcaster;
import model.userAcc.Artist.Singer;
import model.userAcc.Listener.Free;
import model.userAcc.Listener.Listener;


import java.time.LocalDate;
import java.util.Objects;


public class SignUp {
    private static SignUp signUpInstance;

    private SignUp() {}
    public static SignUp signUp() {
        if(signUpInstance==null) {
            signUpInstance = new SignUp();
        }
        return signUpInstance;
    }
    public String signUpListener(String userName, String password, String nameAndFamily, String email, String phoneNumber, LocalDate birthday) throws InvalidFormatException, UserNotFoundException {
        if (!Checker.checkEmail(email)) {
            throw new InvalidFormatException();
        } else {
            if (!Checker.checkPhoneNumber(phoneNumber)) {
                throw new InvalidFormatException();

            } else {
                if (Checker.findUser(userName)) {
                    throw new UserNotFoundException();

                } else {
                   Free newListener = new Free(userName, password,
                            nameAndFamily, email,phoneNumber, birthday);
                    DataBase.getDataBase().setUsers(newListener);
                    Listener.setListener(newListener);
                    return "welcome new listener";
                }

            }
        }
    }
    public String signUpSinger(String userName, String password, String nameAndFamily, String email, String phoneNumber, LocalDate birthday, String biography) throws InvalidFormatException, UserNotFoundException {
        if (!Checker.checkEmail(email)) {
            throw new InvalidFormatException();
        } else {
            if (!Checker.checkPhoneNumber(phoneNumber)) {
                throw new InvalidFormatException();
            } else {
                if (Checker.findUser(userName)) {
                    throw new UserNotFoundException();
                } else {
                    Singer newSinger = new Singer( userName,  password,  nameAndFamily,  email,  phoneNumber, birthday,  biography);
                    DataBase.getDataBase().setUsers(newSinger);
                    Artist.setMainArtist(newSinger);

                    return "welcome new Singer";
                }

            }
        }
    }
    public String signUpPodcaster(String userName, String password, String nameAndFamily, String email, String phoneNumber,LocalDate birthday, String biography) throws InvalidFormatException, UserNotFoundException {
        if (!Checker.checkEmail(email)) {
            throw new InvalidFormatException();
        } else {
            if (!Checker.checkPhoneNumber(phoneNumber)) {
                throw new InvalidFormatException();
            } else {
                if (Checker.findUser(userName)) {
                    throw new UserNotFoundException();
                } else {
                    Podcaster newPodcaster = new  Podcaster(userName, password,
                          nameAndFamily, email, phoneNumber, birthday,biography);
                    DataBase.getDataBase().setUsers(newPodcaster);
                    Artist.setMainArtist(newPodcaster);

                    return "welcome new Podcaster";
                }

            }
        }
    }


































}