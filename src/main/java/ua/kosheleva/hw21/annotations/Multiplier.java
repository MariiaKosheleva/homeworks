package ua.kosheleva.hw21.annotations;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Multiplier {
    String mathematicalSign() default "*";
}
