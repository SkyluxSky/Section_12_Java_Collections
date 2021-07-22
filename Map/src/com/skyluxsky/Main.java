package com.skyluxsky;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //A Map takes two arguments <Key Value, Stored Value that is pointed to by the key>
        Map<String, String> languages = new HashMap<>();

        //Checks if Java Exists - if not add
        if(languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }

        //Stores Keys and Objects in Map
        languages.put("Java", "a compiled high level, object-oriented, platform independent language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        //sout on a .put returns null because it is a new entry.
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        //Check ensures that a key in the map won't be overwritten
        if (languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "This course is about Java");
        }


        //Prints out Java output.
        System.out.println(languages.get("Java"));

        //For a Key there is only one value (it can be overwritten)
        //System.out.println(languages.put("Java", "This course is about Java")); //returns the previous value
        System.out.println(languages.get("Java"));


        //Loops through keys to print out contents (uses keyset() function)
        //Not returned sorted
        System.out.println("================================================");

        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
