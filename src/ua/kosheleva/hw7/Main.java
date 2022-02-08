package ua.kosheleva.hw7;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setManufacturer("BMW");
        car1.setEngine("S54B32");
        car1.setColor("Blue");
        car1.setPetrol(70);

        Car car2 = new Car();
        car2.setManufacturer("Mercedes");
        car2.setEngine("V12");
        car2.setColor("Black");
        car2.setPetrol(60);

        Car car3 = new Car();
        car3.setManufacturer("Fiat");
        car3.setEngine("Fiat Doblo");
        car3.setColor("Green");
        car3.setPetrol(40);

        System.out.println("Car1 characteristics: " + car1);
        System.out.println("Car2 characteristics: " + car2);
        System.out.println("Car3 characteristics: " + car3);
        System.out.println();

        System.out.println(car1.startEngine("Maria"));
        System.out.println();

        System.out.println("Car1 petrol level: " + Car.isEnoughPetrolLevel(car1.getPetrol()));
        System.out.println("Car2 petrol level: " + Car.isEnoughPetrolLevel(car2.getPetrol()));
        System.out.println("Car3 petrol level: " + Car.isEnoughPetrolLevel(car3.getPetrol()));

        //Для выполнения задачи: "Добавить конструктор в класс, который принимает на вход 3 параметра
        // (manufacturer, engine, colour), устанавливает их и дополнительно задает значение petrol = 100

        //Car car4 = new Car("BMW", "S54B32", "Blue");
        //System.out.println("Car4 characteristics: " + car4);

    }
}
