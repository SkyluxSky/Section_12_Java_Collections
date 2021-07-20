package com.skyluxsky;

//Top level of the collections framework is the collections class.
//Returns collections objects likes lists.
//Includes methods that allow arrays to be viewed as collections
//Aggregate Operations

import java.util.*;

public class Main {


    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);


        Theatre theatre = new Theatre("Olympian",8,12);
        theatre.getSeats();

        //Brute Force Algorithm
        if (theatre.reserveSeatBruteForce("G11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        //Error Seat is Taken
//        if (theatre.reserveSeatBruteForce("H11")){
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }


        //Binary Tree Algorithm
        if (theatre.reserveSeatBinaryTree("H12")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }


        //Java Binary Tree Algorithm
        if (theatre.reserveSeatBinarySearchJava("E06")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

/*******************************************************************************************/

        //Copy Array List -Shallow Copy
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);//Copy

        //Copied arraylist still modifies when functions are called on itself
        //Example of two references pointing to the same list/array
        //List #1
        seatCopy.get(1).reserve();
        //List #2
        if (theatre.reserveSeatBinarySearchJava("A02")){
            System.out.println("Please Pay For A02");
        } else {
            System.out.println("Seat already reserved");
        }


        //Collection modification (Proves that both are separate lists)
        //Collections.reverse(seatCopy); //reverses list
        Collections.shuffle(seatCopy); //shuffles list (Pseudo Random)
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seats");
        printList(theatre.seats);


        //Collections Min and Max Values
        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        //Prints Sorted List
        System.out.println();
        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);


        //Collections Copy List
        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList, theatre.seats);
    }


    //Creates a new Array of Seat Objects (Uses Inner Class Notations)
    public static void printList(List<Theatre.Seat> list){
        for (Theatre.Seat seat : list){
            System.out.println(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("============================================================");
    }


    //Bubble Sort
    //List<? extends Theatre.Seat> makes our argument generic - method can sort any theatre that use compareTo method
    public static void sortList(List<? extends Theatre.Seat> list){
        for (int i = 0; i < list.size() - 1; i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i , j);
                }
            }
        }
    }
}
