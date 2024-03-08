package org.example;

public class GoldPassenger extends Passenger {
    private static final double DISCOUNT = 0.9; // 10% discount

    public GoldPassenger(String name, int number, double balance) {
        super(name, number, balance);
    }

    @Override
    public boolean signUpForActivity(Activity activity) {
        double discountedCost = activity.getCost() * DISCOUNT;
        if (canAffordActivity(activity) && !activity.isFull()) {
            registerActivity(activity, discountedCost);
            return true;
        }
        return false;
    }
}