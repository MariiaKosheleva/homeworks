package ua.kosheleva.hw31.task1;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
public class CountThread implements Runnable {
    CommonResource resource;
    ReentrantLock locker;

    @Override
    public void run() {
        locker.lock();
        resource.count += 2;
        System.out.println(resource.getCount());
        locker.unlock();
    }
}
