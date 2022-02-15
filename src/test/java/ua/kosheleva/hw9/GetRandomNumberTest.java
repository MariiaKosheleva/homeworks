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
    private final int num = 10;
    private GetRandomNumber target;

    @BeforeEach
    void setUp() {

        target  = Mockito.mock(GetRandomNumber.class);
        Mockito.when(target.get(num)).thenReturn();
    }

    @Test
    void getNumber_lessThen10_isNotFine(){
        Assertions.assertEquals(200, target.get(r));
    }

}