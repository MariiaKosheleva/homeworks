package model;

import dao.PartDao;
import lombok.SneakyThrows;
import robots.BasicStructureAssembler;
import robots.ChipProgrammer;
import robots.PartShaper;
import service.PartService;
import robots.FuelGetter;

import java.util.Scanner;
import java.util.concurrent.*;

public class Factory {
    private final PartDao partDao = new PartDao();
    private final PartService partService = new PartService();
    public static volatile int fuel = 0;
    public static final Object synchronizer = new Object();

    public void greeter() {
        System.out.println("Welcome to our factory!\n" +
                "Choose which information you want to see:");
        System.out.println("""
                \nInformation which you can find there:
                                
                - Start producing of the part
                - Get whole statistic about factory work
                - Get information about the certain part
                - Exit from menu""");
        System.out.println("\nInput 1 to start program work:");
    }

    public void startFactoryWork() {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = 0;
        int index;
        try {
            inputNumber = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid argument!");
        }
        while (inputNumber != 0) {
            System.out.println("""
                    \n
                    1 - Start producing of the part
                    2 - Get whole statistic about factory work
                    3 - Get information about the certain part
                    0 - Exit from menu""");
            inputNumber = Integer.parseInt(scanner.next());
            if (inputNumber == 1) {
                robotsWork();
            } else if (inputNumber == 2) {
                System.out.println("Statistics of factory work:");
                partService.printStatisticsData();

            } else if (inputNumber == 3) {
                System.out.println("Input index of the part: ");
                index = Integer.parseInt(scanner.next());
                System.out.println("Information about part number " + index + ": ");
                partService.printInfoAboutCertainPart(index);
            } else if (inputNumber == 0) {
                System.out.println("Bye! Thank you for your visit.");
            }
        }
    }

    @SneakyThrows
    private void robotsWork() {
        long startTime = System.currentTimeMillis();
        ExecutorService executorForRobot1 = Executors.newSingleThreadExecutor();
        System.out.println("Robot-1 started its work");
        executorForRobot1.submit(new FuelGetter());

        ExecutorService executorForRobot2AndRobot3 = Executors.newFixedThreadPool(2);
        System.out.println("Robot-2 and Robot-3 started their work");
        for (int i = 0; i < 2; i++) {
            executorForRobot2AndRobot3.submit(new BasicStructureAssembler());
        }
        executorShutdown(executorForRobot2AndRobot3);
        System.out.println("Robot-2 and Robot-3 finished their work");

        ExecutorService executorForRobot4 = Executors.newSingleThreadExecutor();
        System.out.println("Robot-4 started its work");
        Future<Integer> future = executorForRobot4.submit(new ChipProgrammer());
        executorShutdown(executorForRobot4);
        System.out.println("Robot-4 finished its work");

        ExecutorService executorForRobot5 = Executors.newSingleThreadExecutor();
        System.out.println("Robot-5 started its work");
        Future<Integer> future1 = executorForRobot5.submit(new PartShaper());
        executorShutdown(executorForRobot5);
        System.out.println("Robot-5 finished its work");

        executorForRobot1.shutdownNow();
        System.out.println("Robot-1 finished its work");
        long endTime = System.currentTimeMillis();
        partDao.save(new Part((endTime - startTime), (future1.get() + fuel), future.get()));
    }

    private void executorShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(120, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(120, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate!");
            }
        } catch (InterruptedException ie) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
