package ua.kosheleva.hw17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task1:");
        sortStringArray();
        System.out.println("\nTask2:");
        filterNumbers();
        System.out.println("\nTask3:");
        findTheCertainYearInList();
        System.out.println("\nTask4:");
        findMinNumber();
    }

    public static void sortStringArray() {
        String[] arrayOfFruits = {"Peach", "Grapefruit", "Apple", "Orange", "Kiwi"
                , "Banana", "Pear", "Watermelon", "Melon", "Mandarin"};
        Stream<String> streamOfArray = Arrays.stream(arrayOfFruits);
        streamOfArray.sorted()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void filterNumbers() {
        List<Integer> numberList = new Random().ints(10
                        , -50, 50)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        IntSummaryStatistics summaryStatistics = numberList.stream()
                .filter(i -> i >= 0)
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Initial list:");
        System.out.println(numberList);
        System.out.println("SummaryStatistics: ");
        System.out.println("Get count: " + summaryStatistics.getCount() + "\nGet min: " + summaryStatistics.getMin() +
                "\nGet max: " + summaryStatistics.getMax() + "\nGet average: " + summaryStatistics.getAverage() +
                "\nGet sum: " + summaryStatistics.getSum());
    }

    public static void findTheCertainYearInList() {
        List<String> listOfDates = new LinkedList<>();
        listOfDates.add("2017/05/22");
        listOfDates.add("2018/05/22");
        listOfDates.add("2019/05/22");
        listOfDates.add("2020/05/22");
        listOfDates.add("2021/05/22");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        boolean find2021YearDate = listOfDates.stream()
                .map(y -> LocalDate.parse(y, dateTimeFormatter))
                .anyMatch(localDate -> localDate.getYear() == 2021);
        System.out.println("Initial list: ");
        System.out.println(listOfDates);
        if (find2021YearDate) {
            System.out.println("The date with 2021 year exists in initial list.");
        } else {
            System.out.println("The date with 2021 year don't exists in initial list.");
        }
        System.out.println();
    }

    public static void findMinNumber() {
        List<Integer> numberList = new Random().ints(10
                        , -50, 50)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println("Initial list:" + numberList);
        System.out.println("Min value in list: " + numberList.stream()
                .mapToInt(Integer::intValue)
                .reduce(Integer::min)
                .orElse(0));
        System.out.println();
    }
}


