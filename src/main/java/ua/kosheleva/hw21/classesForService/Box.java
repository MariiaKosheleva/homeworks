package ua.kosheleva.hw21.classesForService;

import lombok.ToString;
import ua.kosheleva.hw21.annotations.AutoCreate;
import ua.kosheleva.hw21.annotations.Init;
import ua.kosheleva.hw21.annotations.Multiplier;

@AutoCreate
@ToString
public class Box {
    @Multiplier
    private final String name = "hello";
    @Multiplier
    private final Double size = 3.0;
    @Multiplier(mathematicalSign = "+")
    private final Double size2 = 3.0;
    @Multiplier(mathematicalSign = "+")
    private final Double size3 = 2.0;
    private final Integer weight = 2;

    @Init
    public void printMethodInvokeNotification() {
        System.out.println("Method with annotation @Init has been called in class " + getClass().getSimpleName());
    }
}
