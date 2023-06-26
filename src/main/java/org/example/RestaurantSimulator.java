package org.example;

import static org.example.Utils.*;

public class RestaurantSimulator {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(NUMBER_OF_TABLES);
        for (int i = 1; i <= NUMBER_OF_CUSTOMERS; i++) {
            new Customer(restaurant, "Customer-" + i).start();
            System.out.println("Customer-" + i + " has arrived.");
            Utils.sleep(SECOND);
        }
    }
}
