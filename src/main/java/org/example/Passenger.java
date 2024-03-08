package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Passenger {
    protected String name;
    protected int number;
    protected double balance;
    protected List<Activity> activitiesSignedUpFor;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setActivitiesSignedUpFor(List<Activity> activitiesSignedUpFor) {
        this.activitiesSignedUpFor = activitiesSignedUpFor;
    }

    public Passenger(String name, int number, double balance) {
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.activitiesSignedUpFor = new ArrayList<>();
    }

    public abstract boolean signUpForActivity(Activity activity);

    protected boolean canAffordActivity(Activity activity) {
        return balance >= activity.getCost();
    }

    protected void registerActivity(Activity activity, double cost) {
        this.activitiesSignedUpFor.add(activity);
        this.balance -= cost;
        activity.registerParticipant(this);
    }

    public void printDetails() {
        System.out.println("Passenger Name: " + name + ", Number: " + number + ", Balance: " + balance);
        for (Activity activity : activitiesSignedUpFor) {
            System.out.println("Signed up for: " + activity.getName() + " at " + activity.getDescription() + ", Paid: " + activity.getCost());
        }
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
    public List<Activity> getActivitiesSignedUpFor() {
        return activitiesSignedUpFor;
    }
}
