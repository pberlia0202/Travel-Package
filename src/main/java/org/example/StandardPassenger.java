package org.example;


public class StandardPassenger extends Passenger {
    public StandardPassenger(String name, int number, double balance) {
        super(name, number, balance);
    }

    @Override
    public boolean signUpForActivity(Activity activity) {
        if (canAffordActivity(activity) && !activity.isFull()) {
            registerActivity(activity, activity.getCost());
            return true;
        }
        return false;
    }
}

