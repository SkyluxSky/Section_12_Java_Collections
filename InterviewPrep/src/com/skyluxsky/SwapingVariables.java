package com.skyluxsky;

public class SwapingVariables {
    private int a;
    private int b;

    public SwapingVariables(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void SwapVariables(){
        //Question Number 1
        System.out.println("First Question: Make it so that variable (a) is equal to variable (b)" +
                "\nand variable (b) is equal to variable (a) without creating a third variable...");

        //10 + 13 = 23
        b = a + b;
        System.out.println("\nplaceholder b equals " + b);

        //23 - 10 = 13
        a = b - a;
        System.out.println("\na equals " + a);

        //23 - 13 = 10
        b = b - a;
        System.out.println("b equals " + b);

        //Solution: Therefore both values have been switched...

    }




}
