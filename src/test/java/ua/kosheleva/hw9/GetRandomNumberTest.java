package ua.kosheleva.hw9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.CarFactory;
import test.Person;
import test.PersonFactory;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GetRandomNumberTest {
    private final Random RANDOM = Mockito.mock(Random.class, Mockito.withSettings().withoutAnnotations());
    private GetRandomNumber target = new GetRandomNumber();

    @Test
    void numberIs0_allFine(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(0);
        Assertions.assertEquals(-1, target.get(RANDOM));
    }

    @Test
    void numberMoreThen0LessThen10_allFine(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(5);
        Assertions.assertEquals(200, target.get(RANDOM));
    }

    @Test
    void numberMoreThen10LessThen20_allFine(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(15);
        Assertions.assertEquals(3, target.get(RANDOM));
    }

    @Test
    void numberMoreThen30LessThen50_allFine(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(30);
        Assertions.assertEquals(null, target.get(RANDOM));
    }

    @Test
    void numberMoreThen50LessThen80_allFine(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(70);
        Assertions.assertEquals(-10, target.get(RANDOM));
    }

    @Test
    void numberMoreThen80LessThen100_allFine(){
        Mockito.when(RANDOM.nextInt(100)).thenReturn(90);
        Assertions.assertEquals(90, target.get(RANDOM));
    }



}