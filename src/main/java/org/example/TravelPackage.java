package org.example;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int capacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItinerary(List<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
            return true;
        } else {
            System.out.println("Travel package " + name + " is already full. Cannot add more passengers.");
            return false;
        }

    }

    public void printItinerary() {
        System.out.println("Itinerary for " + name + ":");
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities Available:");
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost()
                        + ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
            System.out.println();
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for " + name + ":");
        System.out.println("Capacity: " + capacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        System.out.println("Passengers:");
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName() + ", Number: " + passenger.getNumber());
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities for " + name + ":");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + " at " + destination.getName() + ", Cost: "
                        + activity.getCost() + ", Capacity: " + activity.getCapacity());
            }
        }
    }
}
