package ua.kosheleva.hw10;

public class PassengerCar extends Car implements Recovery {
    private Passenger[] passengers;

    public PassengerCar(int series, int year, String color) {
        super(series, year, color);
        this.passengers = new Passenger[0];

    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    public void addPassengers(Passenger passenger) {

        if (passengers.length < 3) {
            Passenger[] copy = new Passenger[passengers.length + 1];
            System.arraycopy(passengers, 0, copy, 0, passengers.length);

            copy[copy.length - 1] = passenger;
            setPassengers(copy);
            System.out.println("Add " + copy.length + " passenger(s)");
        } else {
            System.out.println("You can't set more then 3 passengers");
        }
    }

    public void printAllPassengers() {
        if (passengers.length == 0) {
            System.out.println("No passengers in this car");
        } else {
            for (Passenger passenger : passengers) {
                System.out.println(passenger);
            }
        }
    }

    @Override
    public void refuel() {
        super.refuel();
    }
}
