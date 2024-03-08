package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creating Destinations
        Destination paris = new Destination("Paris");
        Destination tokyo = new Destination("Tokyo");

        // Creating Activities for each Destination
        Activity eiffelTour = new Activity("Eiffel Tower Visit", "Guided tour of the Eiffel Tower", 100.0, 5,paris);
        paris.addActivity(eiffelTour);
        Activity sushiWorkshop = new Activity("Sushi Workshop", "Learn to make sushi with a Japanese chef", 150.0, 3,tokyo);
        tokyo.addActivity(sushiWorkshop);

        // Creating Travel Package and adding Destinations
        TravelPackage europeAdventure = new TravelPackage("Europe Adventure", 10);
        europeAdventure.addDestination(paris);
        europeAdventure.addDestination(tokyo);

        // Creating Passengers
        Passenger johnDoe = new StandardPassenger("John Doe", 1, 500.0); // Standard Passenger with $500 balance
        Passenger aliceSmith = new GoldPassenger("Alice Smith", 2, 700.0); // Gold Passenger with $700 balance
        Passenger bobLee = new PremiumPassenger("Bob Lee", 3,10); // Premium Passenger

        // Adding Passengers to the Travel Package
        europeAdventure.addPassenger(johnDoe);
        europeAdventure.addPassenger(aliceSmith);
        europeAdventure.addPassenger(bobLee);

        // Passengers signing up for Activities
        johnDoe.signUpForActivity(eiffelTour);
        aliceSmith.signUpForActivity(sushiWorkshop);
        bobLee.signUpForActivity(sushiWorkshop);

        // Printing Itinerary
        europeAdventure.printItinerary();

        // Printing Passenger List
        europeAdventure.printPassengerList();

        // Printing Available Activities
        europeAdventure.printAvailableActivities();

        // Printing Passenger Details
        johnDoe.printDetails();
        aliceSmith.printDetails();
        bobLee.printDetails();
    }
}