package ua.kosheleva.hw10;

public class Main {
    public static void main(String[] args) {

        System.out.println("Car information: ");
        Car car = new Car(4, 2018, "Black");
        System.out.println("\nMovement: ");
        car.movement();
        System.out.println("\nStatistic: ");
        car.printStatistic();
        System.out.println("\nRefuel your car: ");
        car.refuel();

        System.out.println("\nCar with passengers: ");
        PassengerCar passengerCar = new PassengerCar(5, 2012, "Green");
        System.out.println("\nPassengers which we have: ");
        passengerCar.printAllPassengers();
        System.out.println("\nAdd new passenger: ");
        Passenger passenger1 = new Passenger("Mariia", 18);
        Passenger passenger2 = new Passenger("Mike", 22);
        Passenger passenger3 = new Passenger("Nora", 10);
        Passenger passenger4 = new Passenger("Helen", 6);
        passengerCar.addPassengers(passenger1);
        passengerCar.addPassengers(passenger2);
        passengerCar.addPassengers(passenger3);
        passengerCar.addPassengers(passenger4);
        System.out.println("\nPassengers which we have after adding new ones: ");
        passengerCar.printAllPassengers();
        System.out.println("\nMovement: ");
        passengerCar.movement();
        System.out.println("\nRefuel your car with passengers: ");
        passengerCar.refuel();

        System.out.println("\nTruck information");
        Truck truck = new Truck(3, 2001, "Red");
        System.out.println("\nLet's load or unload your truck");
        System.out.println("with cargo = -1 tons");
        truck.cargoLoadingUnloading(-1);
        System.out.println("with cargo = 4.5 tons");
        truck.cargoLoadingUnloading(4.5);
        System.out.println("with cargo = -0.2 tons");
        truck.cargoLoadingUnloading(-0.2);
        System.out.println("\nMovement: ");
        truck.movement();
        System.out.println("\nRefuel your truck:");
        truck.refuel();
    }
}
