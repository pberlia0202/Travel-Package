
import org.example.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ActivityTest {
    @Test
    public void registerParticipant_Success() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);
        Passenger passenger = new GoldPassenger("John", 1, 500);

        assertFalse(activity.isFull());
        activity.registerParticipant(passenger);
        assertTrue(activity.getParticipants().contains(passenger));
    }

    @Test
    void testRegisterParticipant() {
        // Create an activity with a capacity of 3
        Activity activity = new Activity("Hiking", "Nature walk", 20.0, 3, new Destination("Mountain"));

        // Create passengers for testing
        Passenger passenger1 = new StandardPassenger("Alice", 1, 50.0);
        Passenger passenger2 = new GoldPassenger("Bob", 2, 100.0);
        Passenger passenger3 = new PremiumPassenger("Charlie", 3,100);

        // Register participants
        assertTrue(activity.registerParticipant(passenger1));
        assertTrue(activity.registerParticipant(passenger2));
        assertTrue(activity.registerParticipant(passenger3));

        // Check if participants list is correct
        assertEquals(3, activity.getParticipants().size());
        assertTrue(activity.getParticipants().contains(passenger1));
        assertTrue(activity.getParticipants().contains(passenger2));
        assertTrue(activity.getParticipants().contains(passenger3));

        // Try to register more participants than the capacity
        assertFalse(activity.registerParticipant(new StandardPassenger("Dave", 4, 30.0)));
        assertFalse(activity.registerParticipant(new GoldPassenger("Eve", 5, 80.0)));

        // Check if the participants list remains unchanged
        assertEquals(3, activity.getParticipants().size());
    }

    @Test
    void testIsFull() {
        // Create an activity with a capacity of 2
        Activity activity = new Activity("Camping", "Outdoor camping", 50.0, 2, new Destination("Forest"));

        // Create passengers for testing
        Passenger passenger1 = new StandardPassenger("Alice", 1, 50.0);
        Passenger passenger2 = new GoldPassenger("Bob", 2, 100.0);

        // Register participants up to the capacity
        assertTrue(activity.registerParticipant(passenger1));
        assertFalse(activity.isFull()); // Capacity not reached yet
        assertTrue(activity.registerParticipant(passenger2));
        assertTrue(activity.isFull()); // Capacity reached

        // Try to register more participants after reaching capacity
        assertFalse(activity.registerParticipant(new PremiumPassenger("Charlie", 3,100)));

        // Check if the participants list remains unchanged
        assertEquals(2, activity.getParticipants().size());
    }

    // Add more test cases to cover setters, getters, and other scenarios as needed

}
