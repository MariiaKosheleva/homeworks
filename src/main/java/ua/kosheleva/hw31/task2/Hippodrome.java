package ua.kosheleva.hw31.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static ua.kosheleva.hw31.task2.Race.horseToBet;

public class Hippodrome implements Runnable {
    private final Random random = new Random();
    private long horseToBetResult;
    private List<String> horses = new ArrayList<>();
    private List<Long> results = new ArrayList<>();

    @Override
    public void run() {
        horses.add(Thread.currentThread().getName());
        getIndexInResultTable();
    }

    private long getHorsesResultTime() {
        long start = System.currentTimeMillis();
        int wholeRanDistance = 0;
        int ranInterval = random.nextInt(100, 200);
        int raceDistance = 1000;
        for (int i = 0; i <= raceDistance; i++) {
            int intermediateRanDistance = wholeRanDistance + ranInterval;
            if (i == intermediateRanDistance) {
                try {
                    Thread.sleep(random.nextInt(400, 500));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                wholeRanDistance = intermediateRanDistance;
                ranInterval = random.nextInt(100, 200);
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private void getIndexInResultTable() {
        long duration = getHorsesResultTime();
        results.add(duration);
        List<Long> sortedResults = results.stream()
                .sorted()
                .collect(Collectors.toList());
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).equalsIgnoreCase("pool-1-thread-" + horseToBet)) {
                horseToBetResult = results.get(i);
            }
        }
        int indexInResultTable = sortedResults.indexOf(horseToBetResult);
        System.out.println("Horse to bet finished with index " + indexInResultTable);
    }
}
