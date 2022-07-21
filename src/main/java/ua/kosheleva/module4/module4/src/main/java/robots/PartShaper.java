package robots;

import lombok.SneakyThrows;
import model.Factory;
import robots.FuelGetter;

import java.util.Random;
import java.util.concurrent.Callable;


public class PartShaper implements Callable<Integer> {
    private final FuelGetter fuelGetter = new FuelGetter();
    private static final Random RANDOM = new Random();
    private int point = 0;
    private int usedFuel = 0;

    @SneakyThrows
    @Override
    public Integer call() {
        int neededFuelForWork;
        while (point < 100) {
            neededFuelForWork = RANDOM.nextInt(350, 701);
            if (Factory.fuel >= neededFuelForWork) {
                point += 10;
                synchronized (fuelGetter) {
                    Factory.fuel -= neededFuelForWork;
                }
                usedFuel += neededFuelForWork;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                do {
                    if (Factory.fuel >= neededFuelForWork) {
                        break;
                    }
                } while (true);
            }
        }
        return usedFuel;
    }
}

