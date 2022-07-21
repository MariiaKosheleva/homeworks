package robots;

import model.Factory;

import java.util.Random;

public class FuelGetter implements Runnable {
    private static final Random RANDOM = new Random();

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (this) {
                Factory.fuel += RANDOM.nextInt(500, 1001);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
