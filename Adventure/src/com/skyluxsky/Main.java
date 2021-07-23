package com.skyluxsky;

// Change the program to allow players to type full words, or phrases, then move to the
// correct location based upon their input.
// The player should be able to type commands such as "Go West", "run South", or just "East"
// and the program will move to the appropriate location if there is one.  As at present, an
// attempt to move in an invalid direction should print a message and remain in the same place.
//
// Single letter commands (N, W, S, E, Q) should still be available.

/**Immutable Classes**/
//Protect classes and programs from third parties.


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Default Locations
        //Each time constructor is called, it passes the list of exits to the constructor. (Reuses and updates tempExit Map)
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",tempExit));

        //Temporary Map
        tempExit = new HashMap<String, Integer>();
        //Add Exits - No Map Literals in Java
        //Room 1 - Road and Rooms it connects to
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
        //tempExit.put("Q",0);

        //Room 2 - Hill
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N",5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
        //tempExit.put("Q",0);

        //Room 3 - Building
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W",1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
        //tempExit.put("Q",0);

        //Room 4 - Valley
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
        //tempExit.put("Q",0);

        //Room 5 - Forest
        tempExit = new HashMap<String, Integer>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));

        //tempExit.put("Q",0);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("WEST","W");
        vocabulary.put("EAST","E");


        int loc = 1;
        while (true){
            //Quits game if location 0
            System.out.println(locations.get(loc).getDescription());
            //Issue: Direction can still be removed, as there are direct references to original class.
            //tempExit.remove("S");
            if (loc == 0){
                break;
            }

            //Gets exits that are valid for set locations
            Map<String, Integer> exits = locations.get(loc).getExits();//Gets location from numbers

            //Prints available exits
            System.out.print("Available exits are: ");
            for (String exit: exits.keySet()){
                System.out.println(exit + ", ");
            }
            System.out.println();

            //Gets directions and changes location
            String direction = scanner.nextLine().toUpperCase();

            //Check direction from player, if direction is more than one character.
            if (direction.length() > 1){
                String[] words = direction.split(" ");//Splits words in user input

                //Loops through entered user statement
                for (String word : words){
                    //Check if words contains Key Word
                    if (vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);//direction equals word
                        break;
                    }
                }
            }

            //For multi word responses, the statement below only reads the first letter of a word.
            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction.");
            }

        }

        //Using the split methods (Turns a String into an Array of Strings)
        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
        for(String i : road){
            System.out.println(i);
        }

        System.out.println("===============================");

        String[] building = "You are inside a building, a well house for a small spring".split(", ");
        for(String i : building){
            System.out.println(i);
        }
    }
    
}
