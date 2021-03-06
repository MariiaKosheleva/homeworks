package ua.kosheleva.hw30.task2.util;

import lombok.SneakyThrows;
import ua.kosheleva.hw30.task2.model.ThreadPrimeNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadPrimeNumbersUtil {
    public void printAmountOfPrimeNumbers() {
        System.out.println("All prime numbers: " + createMainThread(createInputList()));
    }

    @SneakyThrows
    private Integer createMainThread(List<Integer> inputList) {
        List<Integer> part1 = new ArrayList<>();
        List<Integer> part2 = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            if (i % 2 == 0) {
                part1.add(inputList.get(i));
            } else {
                part2.add(inputList.get(i));
            }
        }

        ThreadPrimeNumbers t1 = new ThreadPrimeNumbers(part1);
        Thread m1 = new Thread(t1);
        m1.start();
        m1.join();

        ThreadPrimeNumbers t2 = new ThreadPrimeNumbers(part2);
        Thread m2 = new Thread(t2);
        m2.start();
        m2.join();

        return t1.getPrimes() + t2.getPrimes();
    }

    @SneakyThrows
    private List<Integer> createInputList() {
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            inputList.add(new Random().nextInt(0, 10));
        }
        return inputList;
    }
}
