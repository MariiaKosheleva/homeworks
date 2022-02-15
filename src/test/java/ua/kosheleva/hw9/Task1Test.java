package ua.kosheleva.hw9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    private final int[] targetArray1 = {4, 4, 4, 4, 4, 4};
    private final int[] targetArray2 = {2, 2, 2, 2, 2, 2};

    @Test
    void arithmeticMean_allFine(){
        Assertions.assertEquals(4.0f, Task1.arithmeticMean(targetArray1), "Среднее арифметическое неверно");
    }
    @Test
    void geometricMean_allFine(){
        Assertions.assertEquals(2.0f, Task1.geometricMean(targetArray2), "Среднее геометрическое неверно");
    }
}