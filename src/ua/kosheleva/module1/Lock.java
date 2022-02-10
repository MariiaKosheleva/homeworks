package ua.kosheleva.module1;

import java.util.Arrays;

class Lock {
    private final int[] arr;

    public Lock(int[] arr) {
        this.arr = arr.clone();
    }

    public int[] getArr() {
        return arr.clone();
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

}

