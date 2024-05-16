package controller.user;
import model.exception.FailedLogInException.UserNotFoundException;
import model.exception.InvalidFormatException;
import model.DataBase;
import model.userAcc.Artist.Artist;
import model.userAcc.Artist.Podcaster;
import model.userAcc.Artist.Singer;
import model.userAcc.Listener.Free;
import model.userAcc.Listener.Listener;


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

    public String checkNewAcc(String data) throws UserNotFoundException, InvalidFormatException {
        String[] signInData = data.split("-");
        if(Objects.equals(signInData[1], "L")){
            return signUpListener(data);

        }
        if(Objects.equals(signInData[1], "S")){
            return signUpSinger(data);

        }
        if(Objects.equals(signInData[1], "P")){
            return signUpPodcaster(data);

        }
        return "";
    }


    public String signUpListener(String signInInformation) throws InvalidFormatException, UserNotFoundException {
        String[] signInInformations = signInInformation.split("-");
        if (!Checker.checkEmail(signInInformations[5])) {
            throw new InvalidFormatException();
        } else {
            if (!Checker.checkPhoneNumber(signInInformations[6])) {
                throw new InvalidFormatException();

            } else {
                if (Checker.findUser(signInInformations[2])) {
                    throw new UserNotFoundException();

                } else {
                   Free newListener = new Free(signInInformations[2], signInInformations[3],
                            signInInformations[4], signInInformations[5], signInInformations[6], signInInformations[7]);
                    DataBase.getDataBase().setUsers(newListener);
                    Listener.setListener(newListener);
                    return "welcome new listener";
                }

            }
        }
    }
    public String signUpSinger(String signInInformation) throws InvalidFormatException, UserNotFoundException {
        String[] signInInformationsSinger = signInInformation.split("-");
        if (!Checker.checkEmail(signInInformationsSinger[5])) {
            throw new InvalidFormatException();
        } else {
            if (!Checker.checkPhoneNumber(signInInformationsSinger[6])) {
                throw new InvalidFormatException();
            } else {
                if (Checker.findUser(signInInformationsSinger[2])) {
                    throw new UserNotFoundException();
                } else {
                    Singer newSinger = new Singer(signInInformationsSinger[2], signInInformationsSinger[3],
                            signInInformationsSinger[4], signInInformationsSinger[5], signInInformationsSinger[6], signInInformationsSinger[7],signInInformationsSinger[8]);
                    DataBase.getDataBase().setUsers(newSinger);
                    Artist.setMainArtist(newSinger);

                    return "welcome new Singer";
                }

            }
        }
    }
    public String signUpPodcaster(String signInInformation) throws InvalidFormatException, UserNotFoundException {
        String[] signInInformationsArtist = signInInformation.split("-");
        if (!Checker.checkEmail(signInInformationsArtist[5])) {
            throw new InvalidFormatException();
        } else {
            if (!Checker.checkPhoneNumber(signInInformationsArtist[6])) {
                throw new InvalidFormatException();
            } else {
                if (Checker.findUser(signInInformationsArtist[2])) {
                    throw new UserNotFoundException();
                } else {
                    Podcaster newPodcaster = new  Podcaster(signInInformationsArtist[2], signInInformationsArtist[3],
                            signInInformationsArtist[4], signInInformationsArtist[5], signInInformationsArtist[6], signInInformationsArtist[7],signInInformationsArtist[8]);
                    DataBase.getDataBase().setUsers(newPodcaster);
                    Artist.setMainArtist(newPodcaster);

                    return "welcome new Podcaster";
                }

            }
        }
    }


































}