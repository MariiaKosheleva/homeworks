package ua.kosheleva.hw30.task1.model;

public class ThreadGreeter extends Thread {
    private final int index;

    public ThreadGreeter(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("Hello from thread " + index);
    }
}
