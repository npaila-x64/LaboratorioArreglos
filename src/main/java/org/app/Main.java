package org.app;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        HighArray highArray1 = new HighArray(10000);
        HighArray highArray2 = new HighArray(10000);

        for (int index = 0; index < 10000; index++) {
            highArray1.insert(Math.round(Math.random() * 10000));
            highArray2.insert(Math.round(Math.random() * 10000));
        }

        System.out.println("HighArray Test");

        Date startingTime = Calendar.getInstance().getTime();
        int ocurrences = highArray1.getOcurrences(highArray2);
        Date now = Calendar.getInstance().getTime();
        long timeElapsed = now.getTime() - startingTime.getTime();

        System.out.println("Number of ocurrences: " + ocurrences);
        System.out.println("Time of execution: " + timeElapsed + "ms");

        OrdArray ordArray1 = new OrdArray(10000);
        OrdArray ordArray2 = new OrdArray(10000);

        ordArray1.copyElementsOf(highArray1);
        ordArray2.copyElementsOf(highArray2);

        System.out.println("OrdArray Test");

        startingTime = Calendar.getInstance().getTime();
        ocurrences = ordArray1.getOcurrences(ordArray2);
        now = Calendar.getInstance().getTime();
        timeElapsed = now.getTime() - startingTime.getTime();

        System.out.println("Number of ocurrences: " + ocurrences);
        System.out.println("Time of execution: " + timeElapsed + "ms");
    }
}