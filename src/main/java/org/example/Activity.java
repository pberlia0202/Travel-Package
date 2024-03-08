package org.example;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> participants;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.participants = new ArrayList<>();
    }

    public boolean isFull() {
        return participants.size() >= capacity;
    }

    public boolean registerParticipant(Passenger passenger) {
        if (!isFull()) {
            participants.add(passenger);
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setParticipants(List<Passenger> participants) {
        this.participants = participants;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public List<Passenger> getParticipants() {
        return participants;
    }
}