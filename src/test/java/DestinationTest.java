import org.example.Activity;
import org.example.Destination;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DestinationTest {

    @Test
    void testGetName() {
        // Given
        Destination destination = new Destination("Beach");

        // When
        String name = destination.getName();

        // Then
        assertEquals("Beach", name);
    }

    @Test
    void testAddActivity() {
        // Given
        Destination destination = new Destination("Mountain");
        Activity hikingActivity = new Activity("Hiking", "Nature walk", 20.0, 3, destination);

        // When
        destination.addActivity(hikingActivity);

        // Then
        assertTrue(destination.getActivities().contains(hikingActivity));
    }

    @Test
    void testGetActivities() {
        // Given
        Destination destination = new Destination("City");
        Activity shoppingActivity = new Activity("Shopping", "City tour", 30.0, 5, destination);
        Activity sightseeingActivity = new Activity("Sightseeing", "City landmarks", 25.0, 4, destination);

        // When
        destination.addActivity(shoppingActivity);
        destination.addActivity(sightseeingActivity);

        // Then
        List<Activity> activities = destination.getActivities();
        assertEquals(2, activities.size());
        assertTrue(((List<?>) activities).contains(shoppingActivity));
        assertTrue(activities.contains(sightseeingActivity));
    }

    @Test
    void testAddNullActivity() {
        // Given
        Destination destination = new Destination("Mountain");

        // When
        destination.addActivity(null);

        // Then
        // Ensure that the list of activities remains empty
        assertTrue(destination.getActivities().isEmpty());
    }

    @Test
    void testAddDuplicateActivity() {
        // Given
        Destination destination = new Destination("Beach");
        Activity beachActivity = new Activity("Sunbathing", "Relaxing on the sand", 15.0, 10, destination);

        // When
        destination.addActivity(beachActivity);
        destination.addActivity(beachActivity);

        // Then
        // Ensure that the list contains only one instance of the activity
        assertEquals(1, destination.getActivities().size());
    }

    @Test
    void testGetActivitiesEmptyList() {
        // Given
        Destination destination = new Destination("Desert");

        // Then
        // Ensure that the list of activities is initially empty
        assertTrue(destination.getActivities().isEmpty());
    }

}
