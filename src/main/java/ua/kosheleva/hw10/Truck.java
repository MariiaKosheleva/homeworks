package ua.kosheleva.hw10;

public class Truck extends Car implements Recovery {
    private double cargo;

    public Truck(int series, int year, String color) {
        super(series, year, color);
        fuel = 1400;
        this.cargo = 0;
    }

    public void cargoLoadingUnloading(double cargo) {
        if (cargo < 0) {
            if (this.cargo < -cargo || this.cargo == 0) {
                System.out.println("Truck is empty. You can't unload anything now.");
            } else {
                this.cargo += cargo;
                System.out.println("Truck is empty, because cargo was unloaded recently." +
                        "\nWas unloaded " + this.cargo + " tons of cargo");
            }
        } else {
            this.cargo += cargo;
            System.out.println("Truck loaded. Was loaded " + this.cargo + " tons of cargo");
        }
    }

    @Override
    public void movement() {
        super.movement();
        int tripDistance = 0;
        while (fuel > 0) {
            fuel--;
            tripDistance += 100;
            if (fuel % 50 == 0) {
                System.out.println("You travelled: " + tripDistance + "km  \n" +
                        " and left " + fuel + " fuel ");

            }
        }
    }

    @Override
    public void refuel() {
        fuel = 1400;
        System.out.println("Your truck is refueled. \nNow you have: " + fuel + " fuel");
    }
}
