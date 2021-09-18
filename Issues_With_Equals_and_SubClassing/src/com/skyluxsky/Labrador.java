package com.skyluxsky;

public class Labrador extends Dog {

    public Labrador(String name) {
        super(name);
    }

//    @Override
//    public boolean equals(Object obj) {
//        //compares object in memory to see if object is itself!
//        if (this == obj){
//            return true;
//        }
//
//        //Is the object of the Dog class
//        if (obj instanceof Labrador){
//            String objName = ((Labrador) obj).getName();//convert Object to type of Labrador
//            return this.getName().equals(objName); //Calls the getName method instead of directly calling field for comparisons
//        }
//
//        return false; //objects are not the same!
//    }
}
