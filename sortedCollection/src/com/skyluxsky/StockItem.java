package com.skyluxsky;

//Store the name of the item with the name and quantity in stock.
public class StockItem implements Comparable<StockItem>{
    //Fields
    private final String name;
    private double price;
    private int quantityStock = 0; //Can be initialized Later
    private int reserved = 0;

    //Constructors
    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0; //or here (but you would normally do both)
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    //Methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public int quantityInStock() {
        return quantityStock - reserved;
    }

    //Method adjusts total stock
    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;

        if (newQuantity >= 0){
            this.quantityStock = newQuantity;
        }
    }

    //Reserves items based on total available stock for the item.
    public int reserveStock(int quantity){
        if (quantity <= quantityInStock()){//Use the method not the field.
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    //When customer removes items. Items are unreserved
    public int unreserveStock(int quantity){
        if (quantity <= reserved){
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    //Reduces stock levels and reverts reserved back to 0
    public int finalizeStock(int quantity){
        if (quantity <= reserved){
            quantityStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    //Three different tests for equality
    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");

        //Checks if object is the object being passed
        if (obj == this){
            return true;
        }

        //Checks if object is null or a different class
        if (obj == null || (obj.getClass() != this.getClass())){
            return false;
        }

        //Checks object name
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);

    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        //System.out.println("entering StockItem.compareTo");

        if (this == o){
            return 0;
        }

        if (o != null){
            return this.name.compareTo(o.getName());
        }

        //We are not comparing something that is null
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price " + this.price + ". Reserved " + this.reserved;
    }
}
