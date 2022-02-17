package ua.kosheleva.hw9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    private final int[] targetArray = {2, 3, 9, 112, 215, 14};

    @Test
    void replacingEvenNumbersWithZeros_allFine(){
        Assertions.assertArrayEquals(new int[]{0, 3, 9, 0, 215, 0}, Task4.replacingEvenNumbersWithZeros(targetArray), "Замена произведена неверно");

    }

}