package com.skyluxsky;

//Top level of the collections framework is the collections class.
//Returns collections objects likes lists.
//Includes methods that allow arrays to be viewed as collections
//Aggregate Operations

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Theatre theatre = new Theatre("Olympian",8,12);
        theatre.getSeats();

        //Brute Force Algorithm
        if (theatre.reserveSeatBruteForce(scanner.nextLine())){
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
        if (theatre.reserveSeatBinaryTree(scanner.nextLine())){
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

        scanner.close();

    }
}
