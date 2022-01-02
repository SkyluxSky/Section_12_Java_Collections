package com.skyluxsky;

import java.util.*;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        //TreeMap uses compareto method to sort the output
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            //Checks if item is in basket already, if not default to 0
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity); //Adds item to basket with quantity.
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            //check if we already have the item in the basket.
            int inBasket = list.getOrDefault(item, 0);// Returns current quantity or zero
            int newQuantity = inBasket + quantity;

            if (newQuantity > 0){
                list.put(item, newQuantity);
                return quantity;
            } else if(newQuantity == 0){
                list.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    public void clearBasket(){
        this.list.clear();//Clears the entire underlying list.
    }

    public Map<StockItem, Integer> items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        //Use of Terenery Operator to determine the selected string.
        String s = "\nShopping Basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item \n" : " items\n");
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
