package com.skyluxsky;

public class Main {

    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));//returns true
        System.out.println(rover.equals(rover2));//returns false

        //Labrador is an instance of dog, but dog is not an instance of labrador
        //Hence the reason for our instance of test
    }
}
