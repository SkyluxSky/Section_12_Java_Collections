package com.skyluxsky;

import java.util.HashMap;
import java.util.Map;

//Location in an adventure game
public class Location {
    //Fields
    //Private final - allows reader to understand that code should not be changed
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    //Constructor -Will crash with null pointer exception for the Map Exits (Must test arguments)
    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;

        //Fixes Null issue
        if (exits != null){
            this.exits = new HashMap<String, Integer>(exits); //Creates another new hashmap (based on hashmap passed from main method)
        } else {
            this.exits = new HashMap<String, Integer>();
        }

        this.exits.put("Q",0);//Adds location to the code that allows for user to Quit
    }

    //Methods

    //Displays Put method (Automatically configured in constructor)
//    public void addExit(String direction, int location){
//        exits.put(direction,location); //Stores specified exit
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    //Creates duplicate of exits Map to ensure the safety of original exits Map in field.
    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits); //A new map is created, but contains all exits from the original exits map
    }
}
