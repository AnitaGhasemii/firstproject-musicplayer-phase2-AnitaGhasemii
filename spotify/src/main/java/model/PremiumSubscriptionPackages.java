package model;

public enum PremiumSubscriptionPackages {
    oneMonth(5),
    twoMonths(9),
    sixMonths(14);

    private int money;

    PremiumSubscriptionPackages(int value) {
        this.money = value;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
