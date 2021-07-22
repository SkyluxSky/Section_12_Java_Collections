package com.skyluxsky;

import java.util.*;

public class Theatre {
    //Fields
    private final String theatreName;

    //The collections framework contains many different data structures. Many of these are interchangeable
    //This includes ArrayLists, LinkedLists, HashSets, and LinkedHashSets.
    private List<Seat> seats = new ArrayList<>();

    //Comparator Example - Anonymous Inner Class
    static final Comparator<Seat> PRICE_ORDER;//Semi Colon Expected

    //Inconsistent WIth Equals - There are many seats that could share the same price...
    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    //Constructor
    //numRows = number of rows of seats
    //seatsPerRow = number of seats per row
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1); //Gets Last Row
        //Goes through and allocates seats for that section
        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++){

                //====================================================
                //Manage Prices:
                double price = 12.00;

                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)){
                    price = 14.00; //raised price
                } else if (row > 'F' || (seatNum < 4 || seatNum > 9)){
                    price = 7.00;//discount
                }
                //====================================================


                //Format provides format where 0 is always in front of the declared value
                Seat seat = new Seat(row + String.format("%02d",seatNum), price);//EX A01, B01, C01, C02 etc... (As String)
                seats.add(seat);
            }
        }
    }

    //Methods
    public String getTheatreName() {
        return theatreName;
    }

    //Reserves a Seat (Brute Force Algorithm)(O (m * n))
    //Searches every possible value until we find the value we are looking for...
    public boolean reserveSeatBruteForce(String seatNumber){
        Seat requestedSeat = null;

        //Checks the string for all seats
        for (Seat seat : seats){
            System.out.println(".");
            if (seat.getSeatNumber().equals(seatNumber)){
                requestedSeat = seat;
                break;
            }
        }

        if (requestedSeat == null){
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();
    }

 /*************************Binary Search***********************************************/


    //Binary Search Algorithm (O log(n))
    public boolean reserveSeatBinaryTree(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0);//Gives us object for comparison purposes
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null); //uses comparable interface to compare requestedseat to the seats.

        if (foundSeat >= 0){
            return seats.get(foundSeat).reserve(); //returns true
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }


    //Example of Binary Tree From Java's Library
    //More Modifiable than Code Above...
    public boolean reserveSeatBinarySearchJava(String seatNumber){
        int low = 0;
        int high = seats.size()-1; //Last Element - 1

        while (low <= high){
            System.out.println(".");
            int mid = ((low + high) / 2);// Splits Data in Half = mid point
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            //Performs Comparison - Goes until values are equal, if not fails.
            if (cmp < 0){
                low = mid + 1;
            } else if (cmp > 0){
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

 /*****************************************************************************************/

    //For Testing:
    public Collection<Seat> getSeats(){
        return seats;
//        for (Seat seat : seats){
//            System.out.println(seat.getSeatNumber());
//        }
    }


/*******************************************Inner class for Theatre Seats******************************/
    //We can improve performance by implementing a binary tree...
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;//Reserved True or False

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        //reserves a seat
        public boolean reserve(){
            if (!this.reserved){//If seat not reserved set seat to reserved
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        //Cancels reservation - does the opposite of reserve()
        public boolean cancel(){
            if (this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        //Gets Seat Number
        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        //Sets up values for Binary Tree
        @Override
        public int compareTo(Seat seat) {
            //returns a number less than zero, equal to zero, or greater than zero
            // (sets up the ordering for binarytree)
            //If the two seats are the same, then the function returns zero.
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
