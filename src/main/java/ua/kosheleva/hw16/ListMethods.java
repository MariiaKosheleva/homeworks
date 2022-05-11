package ua.kosheleva.hw16;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class ListMethods {
    final static int ELEMENTS_AMOUNT = 100000;
    final public static Random r = new Random();

    public static void fillList(List<Integer> acceptedList) {
        acceptedList.clear();
        for (int i = 0; i < ELEMENTS_AMOUNT; i++) {
            acceptedList.add(r.nextInt());
        }
    }

    public static void getRandomElement(List<Integer> acceptedList) {
        for (int i = 0; i < ELEMENTS_AMOUNT; i++) {
            acceptedList.get(r.nextInt(ELEMENTS_AMOUNT));
        }
    }

    public static void elapsedTime(List<Integer> acceptedList) {
        final Date start = new Date();
        getRandomElement(acceptedList);
        final Date end = new Date();
        System.out.println((end.getTime() - start.getTime()));
    }
}
