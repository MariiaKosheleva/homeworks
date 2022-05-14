package ua.kosheleva.hw17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
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
        System.out.println("\nTask5:");
        task5();

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

    public static void task5() {
        final List<Box> boxList = createCollectionOfBoxes(10);
        System.out.println("Initial collection of boxes:");
        for (Box box : boxList) {
            System.out.println(box);
        }
        final double MIN_SIZE = 30.0;
        final double MAX_SIZE = 50.0;
        Limit<Box> isSuitableForSize = box -> box.getSize() <= (MIN_SIZE + Math.random() *
                (MAX_SIZE - MIN_SIZE + 1));
        System.out.println("\nSorted items from boxes after applying the limit and sorting:");
        List<Item> itemsFromFilteredBoxes = boxList.stream()
                .filter(isSuitableForSize::choise)
                .flatMap(box -> box.getItemList().stream())
                .sorted(Comparator.comparing(Item::getCost))
                .collect(Collectors.toList());
        System.out.println(itemsFromFilteredBoxes);
    }

    public static List<Box> createCollectionOfBoxes(int amountOfBoxes) {
        List<Box> boxList = new ArrayList<>();
        for (int i = 1; i <= amountOfBoxes; i++) {
            boxList.add(new Box((Math.random() + 0.1) * 50, createCollectionOfItems(2)));
        }
        return boxList;
    }

    public static List<Item> createCollectionOfItems(int amountOfItems) {
        List<Item> itemsList = new ArrayList<>();
        for (int i = 1; i <= amountOfItems; i++) {
            itemsList.add(new Item(Math.random() * 10, i));
        }
        return itemsList;
    }
}


