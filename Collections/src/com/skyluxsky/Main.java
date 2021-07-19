package com.skyluxsky;

//Top level of the collections framework is the collections class.
//Returns collections objects likes lists.
//Includes methods that allow arrays to be viewed as collections
//Aggregate Operations

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian",8,12);
        theatre.getSeats();

        //Works
        if (theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        //Error Seat is Taken
        if (theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

    }
}
