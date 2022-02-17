package ua.kosheleva.hw9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2_3Test {
    private final int[] targetArray = {13, 7, 44, 3, 5, 18};

    @Test
    void primeNumbers_allFine(){
        Assertions.assertEquals(4.0f, Task2_3.primeNumbers(targetArray), "Подсчет простых чисел неверен");
    }
    @Test
    void compositeNumbers_allFine(){
        Assertions.assertEquals(2.0f, Task2_3.compositeNumbers(targetArray), "Подсчет составных чисел неверен");
    }

}