package com.skyluxsky;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    //Fields
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    //Constructor
    //numRows = number of rows of seats
    //seatsPerRow = number of seats per row
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1); //Gets Last Row
        //Goes through and allocates seats for that section
        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                //Format provides format where 0 is always in front of the declared value
                Seat seat = new Seat(row + String.format("%02d",seatNum));//EX A01, B01, C01, C02 etc... (As String)
                seats.add(seat);
            }
        }
    }

    //Methods
    public String getTheatreName() {
        return theatreName;
    }

    //Reserves a Seat
    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = null;

        //Checks the string for all seats
        for (Seat seat : seats){
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

    //For Testing:
    public void getSeats(){
        for (Seat seat : seats){
            System.out.println(seat.getSeatNumber());
        }
    }


    /**Inner class for Theatre Seats**/
    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;//Reserved True or False

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
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

        public String getSeatNumber() {
            return seatNumber;
        }
    }


}
