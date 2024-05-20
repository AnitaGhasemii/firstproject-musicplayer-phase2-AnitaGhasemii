package model.userAcc.Listener;

import model.Genre;

import java.time.LocalDate;

public class Premium extends Listener{
    private int leftSubscription;

    public int getLeftSubscription() {
        return leftSubscription;
    }

    public void setLeftSubscription(int leftSubscription) {
        this.leftSubscription = leftSubscription;
    }

    public Premium(String userName, String password, String nameAndFamily, String email, String phoneNumber, LocalDate birthday) {
        super(userName, password, nameAndFamily, email, phoneNumber,birthday);
    }
}
