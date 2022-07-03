package ua.kosheleva.hw31.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        CommonResource resource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.submit(new CountThread(resource, locker));
        }
        executor.shutdown();
    }
}




