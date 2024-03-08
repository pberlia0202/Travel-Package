package org.example;


public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, int number, int balance) {
        super(name, number, balance); // Premium passengers do not need a balance
    }

    @Override
    public boolean signUpForActivity(Activity activity) {
        if (!activity.isFull()) {
            registerActivity(activity, 0); // Cost is 0 for premium passengers
            return true;
        }
        return false;
    }

}