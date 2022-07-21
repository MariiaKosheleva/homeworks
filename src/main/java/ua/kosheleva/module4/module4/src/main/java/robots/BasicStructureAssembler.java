package robots;

import factory.Factory;

import java.util.Random;

public class BasicStructureAssembler implements Runnable {
    private static final Random RANDOM = new Random();
    private static volatile int point = 0;

    @Override
    public void run() {
        while (point < 100) {
            synchronized (Factory.synchronizer) {
                point += RANDOM.nextInt(5, 11);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
