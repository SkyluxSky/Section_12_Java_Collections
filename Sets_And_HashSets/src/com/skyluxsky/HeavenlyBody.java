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


    //Override equals()
    @Override
    public boolean equals(Object obj){
        //Does an Object equal itself?
        if (this == obj){
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());

        //If object is null then they are not equal OR not from the same class, then they are not equal.
        if ((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }

        //Casts the name to a heavenly body datatype.
        String objName = (((HeavenlyBody) obj).getName());
        return this.name.equals(objName);
    }

    //Override hashCode().
    @Override
    public int hashCode() {
        //sets hashcode value for each object
        // - if Stings are equal, they both have the same hashCode.
        System.out.println("Hashcode Called.");
        return this.name.hashCode() + 57; //Guarantees a non zero number is generated.

    }

}
