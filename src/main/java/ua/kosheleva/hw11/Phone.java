package ua.kosheleva.hw11;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public abstract class Phone {
    protected int batteryCapacity;
    protected int numberOfWorkingSpeakers;
    protected int numberOfScreenCracks;

    /*public Phone() {
        batteryCapacity = 100;
        numberOfWorkingSpeakers = 2;
        numberOfScreenCracks = 0;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return batteryCapacity == phone.batteryCapacity && numberOfWorkingSpeakers == phone.numberOfWorkingSpeakers && numberOfScreenCracks == phone.numberOfScreenCracks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, numberOfWorkingSpeakers, numberOfScreenCracks);
    }

    public void service() {
        if (batteryCapacity == 0 || batteryCapacity < 100) {
            System.out.println("Your battery capacity now = " + batteryCapacity);
            batteryCapacity = 100;
            System.out.println("Your battery capacity after service = " + batteryCapacity);
        }
        if (numberOfScreenCracks > 0) {
            System.out.println("Your numberOfScreenCracks now = " + numberOfScreenCracks);
            numberOfScreenCracks = 0;
            System.out.println("Your numberOfScreenCracks after service = " + numberOfScreenCracks);
        }
        if (numberOfWorkingSpeakers == 0 || numberOfWorkingSpeakers < 2) {
            System.out.println("Your numberOfWorkingSpeakers now = " + numberOfWorkingSpeakers);
            numberOfWorkingSpeakers = 2;
            System.out.println("Your numberOfWorkingSpeakers after service = " + numberOfWorkingSpeakers);
        } else {
            System.out.println("Your phone isn't broken! It's reference!");
        }
    }

}
