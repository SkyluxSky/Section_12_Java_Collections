package com.skyluxsky;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        //A linked hash map orders items as they are placed into the Map!
        this.list = new LinkedHashMap<>(); //initialize list as HashMap<String, StockItem>
    }

    //Add item to stock
    public int addStock(StockItem item){
        if (item != null){
            //Gets item if it exists in the Map, if it does not use item.
            //check if we already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);

            //if there are already stocks of this item, adjust quantity.
            if (inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    //Remove items from stock
    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)){
            inStock.adjustStock(-quantity); //negative value is adjusted
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String,StockItem> items(){
        //Read only view of a Map.
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List:\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()){//entrySet == key value and pair
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of ";
            s = s + String.format("%.2f",itemValue) + "\n"; // Formats calculated double to two decimal places...
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
