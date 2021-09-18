package com.skyluxsky;

public class Dog
{
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Equals method cannot be overridded
    @Override
    public final boolean equals(Object obj) {
        //compares object in memory to see if object is itself!
        if (this == obj){
            return true;
        }

        //Is the object of the Dog class
        if (obj instanceof Dog){
            String objName = ((Dog) obj).getName();//convert Object to type of Dog
            return this.name.equals(objName); //returns if comparison is true or not
        }

        return false; //objects are not the same!
    }
}
