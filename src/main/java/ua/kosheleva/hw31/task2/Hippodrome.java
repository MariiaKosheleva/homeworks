package ua.kosheleva.hw31.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ua.kosheleva.hw31.task2.Race.HORSE_TO_BET;

public class Hippodrome implements Runnable {
    private final Random random = new Random();
    private int RACE_DISTANCE = 1000;
    private long horseToBetResult;
    private List<String> horses = new ArrayList<>();

    @Override
    public void run() {
        horses.add(Thread.currentThread().getName());
        while (RACE_DISTANCE >= 0) {
            RACE_DISTANCE -= random.nextInt(100, 200);
            try {
                Thread.sleep(random.nextInt(400, 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        getPlace();
    }

    private void getPlace() {
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).equalsIgnoreCase("pool-1-thread-" + HORSE_TO_BET)) {
                horseToBetResult = horses.indexOf(horses.get(i));
            }
        }
        System.out.println("Horse to bet finished with index " + horseToBetResult);
    }
}
