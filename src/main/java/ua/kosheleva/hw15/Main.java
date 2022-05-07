package ua.kosheleva.hw15;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> lst1 = new MyList<>();
        System.out.println("Task1:");
        System.out.println("Initial list:");
        System.out.println(lst1);
        lst1.addEl(2);
        lst1.addEl(4);
        lst1.addEl(6);
        System.out.println("List after adding elements:");
        System.out.println(lst1);
        System.out.println("Search from last:");
        System.out.println(lst1.getFromLast(2) + " has index: " + lst1.getIndex() + " from the tail");
        System.out.println(lst1.getFromLast(5) + " has index from the tail: " + lst1.getIndex() + " from the tail");
        System.out.println();
        System.out.println("Task2:");
        BoxComparator boxComparator = new BoxComparator();
        TreeSet<Box> boxTreeSet = new TreeSet<>(boxComparator);
        boxTreeSet.add(new Box(14.6));
        boxTreeSet.add(new Box(28.4));
        boxTreeSet.add(new Box(0));
        boxTreeSet.add(new Box(64.3));
        boxTreeSet.add(new Box(0));
        boxTreeSet.add(new Box(10));
        boxTreeSet.add(new Box(32.5));
        for (Box box : boxTreeSet) {
            System.out.println(box.getVolume());
        }
    }
}
