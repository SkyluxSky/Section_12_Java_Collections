package com.skyluxsky;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    //Creates new HashMap and initialize it
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    //Creates new HashSet and initialize it
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
	    //A set has no defined order.
        //Sets do not contain duplicate values.
        //You cannot retrieve a specific element of a set
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new Planet("Venus", 88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp = new Planet("Earth", 88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getName(),tempMoon);
        //Adds moon to the last planet (Which is Earth).
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Temp is Jupiter (so all moons of Jupiter are added to temp)
        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);


        //Using iterations to navigate our Set and Map

        System.out.println("Planets");
        //For each planet in planets Set
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        //Prints out moons of planets
        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        //For each moon in that satellites set.
        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }



        //Creates a new hashset of moons
        Set<HeavenlyBody> moons = new HashSet<>();

        //Adds all existing moons to set...
        for(HeavenlyBody planet : planets) {
            //addAll set shows us a mathematical union or U of a set
            //This only displays values that may be duplicate once.
            moons.addAll(planet.getSatellites());
        }

        //Print out moons with for each iterator
        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        //Add additional pluto (A set cannot contain two of the same object)
        //the .equals() method needs to be rewritten to ensure that there are no duplicates in the set.

        HeavenlyBody pluto = new DwarfPlanet("Pluto", 845);
        planets.add(pluto);


        System.out.println("To String Function: Converts all passed field values to strings");
        for (HeavenlyBody planet : planets){
            //System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
            System.out.println(planet);
        }

        Object o = new Object();
        o.equals(o);
        "pluto".equals("");


        //Test EqualsTo method
        HeavenlyBody earth1 = new Planet("Earth",365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals((pluto)));
        System.out.println(pluto.equals(earth1));

    }
}
