package com.skyluxsky;

import java.util.HashMap;
import java.util.Map;

//Location in an adventure game
public class Location {
    //Fields
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    //Constructor
    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
    }

    //Methods
    public void addExit(String direction, int location){
        exits.put(direction,location); //Stores specified exit
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits); //A new map is created, but contains all exits from the original exits map
    }
}
