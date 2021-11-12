package com.skyluxsky;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    //private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    //private final BodyTypes bodyType; // The type of celestial body the object is

    //Define an enum - allows for a list of constants to be defined.
    //Enums allows for checking for errors at compile time!!!
    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        //this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        //initialize Hashset Class
        this.satellites = new HashSet<>();
        //this.bodyType = bodyType; //Sets bodytype as value from enumerated list of constants(Only accepts values in enumerated list).
    }

    //Methods
    //Getter for name
//    public String getName() {
//        return name;
//    }

    //Getter for orbital period
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    //    public BodyTypes getBodyType() {
//        return bodyType;
//    }

    public boolean addSatellite(HeavenlyBody moon){
            return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        //Creates immutable object by returning new HashSet<>
        return new HashSet<>(this.satellites);
    }


    //Override equals()
    @Override
    public final boolean equals(Object obj){
        //Does an Object equal itself?
        if (this == obj){
            return true;
        }

//        System.out.println("obj.getClass() is " + obj.getClass());
//        System.out.println("this.getClass() is " + this.getClass());

        //If object is null then they are not equal OR not from the same class, then they are not equal.
//        if ((obj == null) || (obj.getClass() != this.getClass())){
//            return false;
//        }

        //Subclass heavenly body
        //
        if (obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }

        //Casts the name to a heavenly body datatype.
        //String objName = (((HeavenlyBody) obj).getName());
        return false;
    }

    //Override hashCode().
    @Override
    public final int hashCode() {
        //sets hashcode value for each object
        // - if Stings are equal, they both have the same hashCode.
        //System.out.println("Hashcode Called.");

        //Each enumerated list Item has their own hashcode...
        //return this.name.hashCode() + 57 + this.bodyType.hashCode(); //Guarantees a non zero number is generated.

        //Returns hashcode from Key class
        return this.key.hashCode();
    }

    //Allows for us to search hashmap with key
    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }

    //Override toString - Java will call a toString to call filed items as Strings.
    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }


    //Addresses issue with having bodytype and name paired.
    public static final class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            //Creates unique hashcode
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;

            //Double checks to make sure passed object is equal.
            if(this.name.equals(key.getName())){
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
