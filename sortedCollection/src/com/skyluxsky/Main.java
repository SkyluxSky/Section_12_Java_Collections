package com.skyluxsky;

//Linked HashMap and HashSet

import java.util.Map;

public class Main {
    private static final StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
	    stockList.addStock(temp);

	    temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.5, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        //Overwrites Cups Price
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        //Gets Keys in HashMap
        for (String s : stockList.items().keySet()){
            System.out.println(s);
        }

        Basket camsBasket = new Basket("Cam");

        sellItem(camsBasket, "car", 1);
        System.out.println(camsBasket);

        sellItem(camsBasket, "car", 1);
        System.out.println(camsBasket);

        sellItem(camsBasket, "car", 100);

        //Test product that doesn't exist
        sellItem(camsBasket, "spanner", 5);
        //System.out.println(camsBasket);

        if (sellItem(camsBasket, "car",1)!= 1){
            System.out.println("There are no more cars in stock!");
        }

        sellItem(camsBasket, "juice", 4);
        sellItem(camsBasket, "cup", 12);
        sellItem(camsBasket, "bread", 1);
        //System.out.println(camsBasket);

        //System.out.println(stockList);

        //Test New Functionality
        Basket basket = new Basket("customer");
        sellItem(basket,"cup", 100);
        sellItem(basket,"juice", 5);
        removeItem(basket,"cup", 1);
        System.out.println(basket);

        removeItem(camsBasket, "car", 1);
        removeItem(camsBasket, "cup", 9);
        removeItem(camsBasket, "car", 1);
        System.out.println("cars removed: " + removeItem(camsBasket, "car", 1)); //should not remove any cars from basket
        System.out.println(camsBasket);

        //remove all item from basket
        removeItem(camsBasket, "bread", 1);
        removeItem(camsBasket, "cup", 3);
        removeItem(camsBasket, "juice", 4);
        removeItem(camsBasket, "cup", 3);
        System.out.println(camsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        //Unsupported operation exception
        //You cant add values to an unmodifiable map...
        //temp = new StockItem("pen",1.12);
        //stockList.items().put(temp.getName(), temp);

        //Can adjust stock value from main class
        StockItem car = stockList.items().get("car");
        //test boundary conditions
        if (car != null){
            car.adjustStock(2000);
        }
        if (car != null){
            stockList.get("car").adjustStock(-1000);
        }
        System.out.println(stockList);

        //Immutable Linked list
//        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()){
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        checkOut(camsBasket);
        System.out.println(camsBasket);

    }

    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);

        //Test to see if item exists
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        //Valid Quantity is taken out of stock
        if (stockList.reserveStock(item,quantity) != 0){
            //basket.addToBasket(stockItem, quantity);
            return basket.addToBasket(stockItem,quantity);
        }

        //User entered in larger than current items in stock.
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        //retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);

        //Test to see if item exists
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        //Unreserves Stock
        if (basket.removeFromBasket(stockItem,quantity) == quantity){
            return stockList.unreserveStock(item, quantity);
        }

        //User entered in larger than current items in stock.
        return 0;
    }

    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem, Integer> item : basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }
}
