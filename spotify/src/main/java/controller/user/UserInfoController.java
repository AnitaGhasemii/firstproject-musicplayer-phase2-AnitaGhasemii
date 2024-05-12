package controller.user;

import model.userAcc.Admin;
import model.userAcc.Artist.Artist;
import model.userAcc.Listener.Listener;

public class UserInfoController {
    private static UserInfoController userInfoControllerInstance;
    public static UserInfoController getUserInfoControllerInstance() {
        if(userInfoControllerInstance==null) {
            userInfoControllerInstance = new UserInfoController();
        }
        return userInfoControllerInstance;
    }
    public  String UserInfo(){
        if(Listener.getListener()!=null){
            return Listener.getListener().toString();
        }
        if(Artist.getMainArtist()!=null){
            ArtistControl.getArtistControlInstance().calculateEarningsUpdate();
            return Artist.getMainArtist().toString();

        }
        if(Admin.getAdmin()!=null){
            return Admin.getAdmin().toString();

        }
        return"";
    }

}
