import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    void testStandardPassengerSignUpForActivity() {
        // Given
        Passenger passenger = new StandardPassenger("Alice", 1, 50.0);
        Activity hikingActivity = new Activity("Hiking", "Nature walk", 20.0, 3, new Destination("Mountain"));

        // When
        boolean signedUp = passenger.signUpForActivity(hikingActivity);

        // Then
        assertTrue(signedUp);
        assertEquals(1, passenger.getActivitiesSignedUpFor().size());
        assertEquals(hikingActivity, passenger.getActivitiesSignedUpFor().get(0));
    }

    @Test
    void testGoldPassengerSignUpForActivity() {
        // Given
        Passenger passenger = new GoldPassenger("Bob", 2, 100.0);
        Activity sailingActivity = new Activity("Sailing", "Boat trip", 30.0, 5, new Destination("Sea"));

        // When
        boolean signedUp = passenger.signUpForActivity(sailingActivity);

        // Then
        assertTrue(signedUp);
        assertEquals(1, passenger.getActivitiesSignedUpFor().size());
        assertEquals(sailingActivity, passenger.getActivitiesSignedUpFor().get(0));
    }

    @Test
    void testPremiumPassengerSignUpForActivity() {
        // Given
        Passenger passenger = new PremiumPassenger("Charlie", 3, 100);
        Activity helicopterTourActivity = new Activity("Helicopter Tour", "Aerial view", 100.0, 2, new Destination("City"));

        // When
        boolean signedUp = passenger.signUpForActivity(helicopterTourActivity);

        // Then
        assertTrue(signedUp);
        assertEquals(1, passenger.getActivitiesSignedUpFor().size());
        assertEquals(helicopterTourActivity, passenger.getActivitiesSignedUpFor().get(0));
    }

    @Test
    void testStandardPassengerSignUpForFullActivity() {
        // Given
        Passenger passenger = new StandardPassenger("Bob", 2, 50.0);
        Activity fullActivity = new Activity("Concert", "Music festival", 40.0, 1, new Destination("City"));
        fullActivity.registerParticipant(new StandardPassenger("Alice", 1, 50.0)); // Make the activity full

        // When
        boolean signedUp = passenger.signUpForActivity(fullActivity);

        // Then
        assertFalse(signedUp); // Should not be able to sign up for a full activity
        assertTrue(passenger.getActivitiesSignedUpFor().isEmpty()); // Ensure activities list is not modified
        assertEquals(50.0, passenger.getBalance(), 0.01); // Ensure balance remains unchanged
    }

    @Test
    void testGoldPassengerSignUpForExpensiveActivity() {
        // Given
        Passenger passenger = new GoldPassenger("Charlie", 3, 100.0);
        Activity expensiveActivity = new Activity("Helicopter Tour", "Aerial view", 200.0, 2, new Destination("City"));

        // When
        boolean signedUp = passenger.signUpForActivity(expensiveActivity);

        // Then
        assertFalse(signedUp);
        assertEquals(0, passenger.getActivitiesSignedUpFor().size());
        assertEquals(100.0, passenger.getBalance()); // Ensure balance is updated with the discount
    }

    @Test
    void testPremiumPassengerSignUpForFreeActivity() {
        // Given
        Passenger passenger = new PremiumPassenger("Dave", 4, 100);
        Activity freeActivity = new Activity("Free Tour", "Guided tour", 0.0, 5, new Destination("City"));

        // When
        boolean signedUp = passenger.signUpForActivity(freeActivity);

        // Then
        assertTrue(signedUp);
        assertEquals(1, passenger.getActivitiesSignedUpFor().size());
        assertEquals(freeActivity, passenger.getActivitiesSignedUpFor().get(0));
        assertEquals(100.0, passenger.getBalance(), 0.01); // Ensure balance remains 0 for premium passengers
    }

    @Test
    void testSetName() {
        // Given
        Passenger passenger = new StandardPassenger("Eve", 5, 50.0);

        // When
        passenger.setName("New Name");

        // Then
        assertEquals("New Name", passenger.getName());
    }

    @Test
    void testGoldPassengerSignUpForDiscountedActivity() {
        // Given
        GoldPassenger goldPassenger = new GoldPassenger("Alice", 1, 100.0);
        Activity expensiveActivity = new Activity("Helicopter Tour", "Aerial view", 100.0, 2, new Destination("City"));

        // When
        boolean signedUp = goldPassenger.signUpForActivity(expensiveActivity);

        // Then
        assertTrue(signedUp);
        assertEquals(1, goldPassenger.getActivitiesSignedUpFor().size());
        assertEquals(expensiveActivity, goldPassenger.getActivitiesSignedUpFor().get(0));
        assertEquals(10.0, goldPassenger.getBalance(), 0.01); // Ensure balance is updated with the discount
    }

    @Test
    void testGoldPassengerSignUpForFullActivity() {
        // Given
        GoldPassenger goldPassenger = new GoldPassenger("Bob", 2, 100.0);
        Activity fullActivity = new Activity("Concert", "Music festival", 40.0, 1, new Destination("City"));
        fullActivity.registerParticipant(new StandardPassenger("Alice", 1, 50.0)); // Make the activity full

        // When
        boolean signedUp = goldPassenger.signUpForActivity(fullActivity);

        // Then
        assertFalse(signedUp); // Should not be able to sign up for a full activity
        assertTrue(goldPassenger.getActivitiesSignedUpFor().isEmpty()); // Ensure activities list is not modified
        assertEquals(100.0, goldPassenger.getBalance(), 0.01); // Ensure balance remains unchanged
    }

    @Test
    void testGoldPassengerSignUpForExpensiveButAffordableActivity() {
        // Given
        GoldPassenger goldPassenger = new GoldPassenger("Charlie", 3, 150.0);
        Activity expensiveActivity = new Activity("Luxury Cruise", "Sailing in style", 120.0, 3, new Destination("Sea"));

        // When
        boolean signedUp = goldPassenger.signUpForActivity(expensiveActivity);

        // Then
        assertTrue(signedUp);
        assertEquals(1, goldPassenger.getActivitiesSignedUpFor().size());
        assertEquals(expensiveActivity, goldPassenger.getActivitiesSignedUpFor().get(0));
        assertEquals(42, goldPassenger.getBalance(), 0.01); // Ensure balance is updated correctly
    }



    @Test
    void testPremiumPassengerSignUpForFullActivity() {
        // Given
        PremiumPassenger premiumPassenger = new PremiumPassenger("Bob", 2,100);
        Activity fullActivity = new Activity("Concert", "Music festival", 40.0, 1, new Destination("City"));
        fullActivity.registerParticipant(new StandardPassenger("Alice", 1, 50.0)); // Make the activity full

        // When
        boolean signedUp = premiumPassenger.signUpForActivity(fullActivity);

        // Then
        assertFalse(signedUp); // Should not be able to sign up for a full activity
        assertTrue(premiumPassenger.getActivitiesSignedUpFor().isEmpty()); // Ensure activities list is not modified
        assertEquals(100.0, premiumPassenger.getBalance()); // Ensure balance remains 0 for premium passengers
    }



}
