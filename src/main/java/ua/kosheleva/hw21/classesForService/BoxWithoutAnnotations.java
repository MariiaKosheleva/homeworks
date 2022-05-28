package ua.kosheleva.hw21.classesForService;

public class BoxWithoutAnnotations {
    private final String name = "hello";
    private final Double size = 3.0;
    private final Double size2 = 3.0;
    private final Double size3 = 2.0;
    private final Integer weight = 2;

    public void printMethodInvokeNotification() {
        System.out.println("Method with annotation @Init has been called in class " + getClass().getSimpleName());
    }
}
