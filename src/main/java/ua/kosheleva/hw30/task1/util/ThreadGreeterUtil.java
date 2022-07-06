package ua.kosheleva.hw30.task1.util;

import lombok.SneakyThrows;
import ua.kosheleva.hw30.task1.model.ThreadGreeter;

public class ThreadGreeterUtil {
    private static final int THREADS_COUNT = 50;

    public void printThread() {
        runThreads(createThreads());
    }

    @SneakyThrows
    private void runThreads(Thread[] threads) {
        for (int i = THREADS_COUNT - 1; i >= 0; i--) {
            threads[i].start();
            threads[i].join();
        }
    }

    @SneakyThrows
    private Thread[] createThreads() {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new ThreadGreeter(i);
        }
        return threads;
    }
}
