package org.example;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;
    public void setName(String name) {
        this.name = name;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }



    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        // Check for duplicates before adding the activity
        if (activity != null && !activities.contains(activity)) {
            activities.add(activity);
        }
    }
}
