package ua.kosheleva.hw11;

public class ReferencePhone extends Phone {

    public ReferencePhone(int batteryCapacity, int numberOfWorkingSpeakers, int numberOfScreenCracks) {
        super(batteryCapacity, numberOfWorkingSpeakers, numberOfScreenCracks);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
