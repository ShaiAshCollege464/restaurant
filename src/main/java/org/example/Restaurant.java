package org.example;

class Restaurant {

    private int numberOfTablesAvailable;
    private final Object takeTableLock;
    private final Object freeTableLock;

    public Restaurant(int numberOfTables) {
        this.numberOfTablesAvailable = numberOfTables;
        this.takeTableLock = Utils.getLock();
        this.freeTableLock = Utils.getLock();
    }

    public void takeTable() throws InterruptedException {
        synchronized (this.getLock(true)) {
            if (numberOfTablesAvailable == 0) {
                System.out.println(Thread.currentThread().getName() + " wants to take a table but none are available. Waiting...");
                takeTableLock.wait();
            }
            Thread.sleep(50);
            numberOfTablesAvailable--;
            System.out.println(Thread.currentThread().getName() + " has taken a table. Tables left: " + numberOfTablesAvailable);
        }
    }

    public void freeTable() throws InterruptedException {
        synchronized (this.getLock(false)) {
            Thread.sleep(50);
            numberOfTablesAvailable++;
            System.out.println(Thread.currentThread().getName() + " freed a table. Tables left: " + numberOfTablesAvailable);
        }
    }

    private Object getLock (boolean take) {
        return take ? takeTableLock : freeTableLock;
    }
}
