package ua.kosheleva.hw7;

public class Car {
    private String manufacturer;
    private String engine;
    private String color;
    private int petrol;

    //Для выполнения задачи: "Добавить конструктор в класс, который принимает на вход 3 параметра
    // (manufacturer, engine, colour), устанавливает их и дополнительно задает значение petrol = 100

    /*public test.Car(String manufacturer, String engine, String color){
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        petrol = 100;
    }*/

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPetrol() {
        return petrol;
    }

    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    public String toString() {
        return " manufacturer - " + this.manufacturer + ", engine -  " + this.engine + ",  color - " + this.color + ",  petrol - " + this.petrol;
    }

    public String startEngine(String name) {
        return name + " started the engine";
    }

    public static boolean isEnoughPetrolLevel(int petrol) {
        return petrol >= 50;
    }

}
