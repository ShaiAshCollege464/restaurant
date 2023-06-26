package org.example;

public class Utils {
    public static final int NUMBER_OF_TABLES = 8;
    public static final int NUMBER_OF_CUSTOMERS = 1000;
    public static final int SECOND = 1000;

    public static Object getLock () {
        return new Object();
    }

    public static void sleep (int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
