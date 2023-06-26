package org.example;

import static org.example.Utils.SECOND;

class Customer extends Thread {
    private final Restaurant restaurant;

    public Customer(Restaurant restaurant, String customerName) {
        super(customerName);
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            while (true) {
                Utils.sleep((int) (Math.random() * 3 * SECOND));
                restaurant.takeTable();
                Utils.sleep((int) (Math.random() * 3 * SECOND));
                restaurant.freeTable();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
