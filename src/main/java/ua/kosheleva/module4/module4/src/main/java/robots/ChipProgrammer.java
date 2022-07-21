package robots;

import java.util.Random;
import java.util.concurrent.Callable;

public class ChipProgrammer implements Callable<Integer> {
    private static final Random RANDOM = new Random();
    private int point = 0;
    private int amountOfBrokenChips = 0;

    @Override
    public Integer call() {
        while (point < 100) {
            point += RANDOM.nextInt(25, 36);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            if (RANDOM.nextInt(0, 101) <= 30) {
                ++amountOfBrokenChips;
                point = 0;
            }
        }
        return amountOfBrokenChips;
    }
}
