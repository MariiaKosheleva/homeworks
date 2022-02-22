package ua.kosheleva.hw10;

public class Car implements Recovery {
    protected int series;
    protected int year;
    protected String color;
    protected double fuel = 140;

    public Car(int series, int year, String color) {
        this.series = series;
        this.year = year;
        this.color = color;
        //fuel = 140;
    }

    public void movement() {
        int tripDistance = 0;
        while (fuel > 0) {
            fuel--;
            tripDistance += 10;
            if (fuel % 10 == 0) {
                System.out.println("You travelled: " + tripDistance + "km  \n" +
                        " and left " + fuel + " fuel ");

            }
        }
        System.out.println("\nYour trip is over, because you have no fuel");
    }

    public void printStatistic() {
        System.out.println("Series: " + series + "\nYear: " + year + "\nColor: " + color + "\nFuel: " + fuel);
    }

    @Override
    public void refuel() {
        fuel = 140;
        System.out.println("Your car is refueled. \nNow you have: " + fuel + " fuel");
    }
}



