package com.skyluxsky;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        //initialize Hashset Class
        this.satellites = new HashSet<>();
    }

    //Methods
    //Getter for name
    public String getName() {
        return name;
    }

    //Getter for orbital period
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        //Returns true or false if moon was added
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        //Creates immutable object by returning new HashSet<>
        return new HashSet<>(this.satellites);
    }
}
