package com.skyluxsky;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {

        //Initialize question #1
        SwapingVariables questionOne = new SwapingVariables(10,13);
        questionOne.SwapVariables();

        //Initialize question #2
        TwoSum questionTwo = new TwoSum();

        int[] array = {0,4,8,12};

        for (int i: array){
            System.out.println(i);
        }

        int[] arr = questionTwo.findTwoSumSorting(array, 20);
        for (int i: arr){
            System.out.println(i);
        }


    }
}
