import org.example.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TravelPackageTest {

    @Test
    void testAddDestination() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Adventure Trip", 3);
        Destination destination1 = new Destination("Mountain");
        Destination destination2 = new Destination("Beach");

        // When
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // Then
        assertEquals(2, travelPackage.getItinerary().size());
        assertTrue(travelPackage.getItinerary().contains(destination1));
        assertTrue(travelPackage.getItinerary().contains(destination2));
    }

    @Test
    void testAddPassengerToAvailableCapacity() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Beach Retreat", 3);
        Passenger passenger = new StandardPassenger("Alice", 1, 50.0);

        // When
        travelPackage.addPassenger(passenger);

        // Then
        assertTrue(travelPackage.getPassengers().contains(passenger));
    }

    @Test
    void testAddPassengerToFullCapacity() {
        // Given
        TravelPackage travelPackage = new TravelPackage("City Exploration", 2);
        Passenger passenger1 = new StandardPassenger("Alice", 1, 50.0);
        Passenger passenger2 = new StandardPassenger("Bob", 2, 60.0);
        Passenger passenger3 = new StandardPassenger("Charlie", 3, 70.0);

        // When
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3); // This passenger should not be added

        // Then
        assertFalse(travelPackage.getPassengers().contains(passenger3));
    }

    @Test
    void testPrintItinerary() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Historical Tour", 2);
        Destination destination1 = new Destination("City");
        Destination destination2 = new Destination("Museum");
        Activity activity1 = new Activity("City Walk", "Exploring the city", 20.0, 5, destination1);
        Activity activity2 = new Activity("Guided Tour", "Museum tour", 15.0, 3, destination2);
        destination1.addActivity(activity1);
        destination2.addActivity(activity2);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // When
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        travelPackage.printItinerary();
        System.setOut(System.out);  // Reset System.out to the console

        // Then
        String expectedOutput = "Itinerary for Historical Tour:" + System.lineSeparator() +
                "Destination: City" + System.lineSeparator() +
                "Activities Available:" + System.lineSeparator() +
                "Activity: City Walk, Cost: 20.0, Capacity: 5, Description: Exploring the city" + System.lineSeparator() +
                System.lineSeparator() +
                "Destination: Museum" + System.lineSeparator() +
                "Activities Available:" + System.lineSeparator() +
                "Activity: Guided Tour, Cost: 15.0, Capacity: 3, Description: Museum tour" + System.lineSeparator() +
                System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    void testPrintPassengerList() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Adventure Trip", 3);
        Passenger passenger1 = new StandardPassenger("Alice", 1, 50.0);
        Passenger passenger2 = new StandardPassenger("Bob", 2, 60.0);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        // When
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        travelPackage.printPassengerList();
        System.setOut(System.out);  // Reset System.out to the console

        // Then
        String expectedOutput = "Passenger List for Adventure Trip:" + System.lineSeparator() +
                "Capacity: 3" + System.lineSeparator() +
                "Number of Passengers Enrolled: 2" + System.lineSeparator() +
                "Passengers:" + System.lineSeparator() +
                "Name: Alice, Number: 1" + System.lineSeparator() +
                "Name: Bob, Number: 2" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testPrintAvailableActivities() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Nature Retreat", 2);
        Destination destination1 = new Destination("Forest");
        Destination destination2 = new Destination("Lake");
        Activity activity1 = new Activity("Hiking", "Nature walk", 20.0, 5, destination1);
        Activity activity2 = new Activity("Boat Tour", "Exploring the lake", 15.0, 3, destination2);
        destination1.addActivity(activity1);
        destination2.addActivity(activity2);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // When
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        travelPackage.printAvailableActivities();
        System.setOut(System.out);  // Reset System.out to the console

        // Then
        String expectedOutput = "Available Activities for Nature Retreat:" + System.lineSeparator() +
                "Activity: Hiking at Forest, Cost: 20.0, Capacity: 5" + System.lineSeparator() +
                "Activity: Boat Tour at Lake, Cost: 15.0, Capacity: 3" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testAddPassengerToFullPackage() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Full Package", 2);
        Passenger passenger1 = new StandardPassenger("Alice", 1, 50.0);
        Passenger passenger2 = new StandardPassenger("Bob", 2, 60.0);
        Passenger passenger3 = new StandardPassenger("Charlie", 3, 70.0);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        // When
        travelPackage.addPassenger(passenger3);

        // Then
        assertEquals(2, travelPackage.getPassengers().size());
        assertFalse(travelPackage.getPassengers().contains(passenger3));
    }

    @Test
    void testAddPassengerToAvailablePackage() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Available Package", 3);
        Passenger passenger1 = new StandardPassenger("Alice", 1, 50.0);
        Passenger passenger2 = new StandardPassenger("Bob", 2, 60.0);
        Passenger passenger3 = new StandardPassenger("Charlie", 3, 70.0);

        // When
        boolean addedPassenger1 = travelPackage.addPassenger(passenger1);
        boolean addedPassenger2 = travelPackage.addPassenger(passenger2);
        boolean addedPassenger3 = travelPackage.addPassenger(passenger3);

        // Then
        assertTrue(addedPassenger1);
        assertTrue(addedPassenger2);
        assertTrue(addedPassenger3);
        assertEquals(3, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger1));
        assertTrue(travelPackage.getPassengers().contains(passenger2));
        assertTrue(travelPackage.getPassengers().contains(passenger3));
    }


}
