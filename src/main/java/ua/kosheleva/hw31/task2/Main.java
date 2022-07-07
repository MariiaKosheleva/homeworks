package ua.kosheleva.hw31.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ua.kosheleva.hw31.task2.Race.amountOfHorses;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        race.enterAmountOfHorsesForRace();
        race.chooseHorseToBet();
        Runnable hippodrome = new Hippodrome();
        ExecutorService executorService = Executors.newFixedThreadPool(amountOfHorses);
        for (int i = 0; i < amountOfHorses; i++) {
            executorService.submit(hippodrome);
        }
        executorService.shutdown();
    }
}
