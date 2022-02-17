package ua.kosheleva.hw9;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class GetRandomNumber {

    public static Integer get(Random random) {
        final int number = random.nextInt(100);

//исправила ошибку добавив условие
        if (number == 0) {
            return -1;
        }
//деление на number, который меньше 10, а если будет number = 0, то деление на 0, что выдаст ошибку
        if (number < 10) {
               return 1000 / number;
        }

        if (number < 20) {
            return number / 5;
        }

        if (number < 50) {
            return null;
        }

        if (number < 80) {
            return -10;
        }
        return number;
    }
}

