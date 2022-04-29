package ua.kosheleva.hw11;

public class PushButtonPhone extends Phone {
    private int outPutNumber = 0;

    public PushButtonPhone(int batteryCapacity, int numberOfWorkingSpeakers, int numberOfScreenCracks, int outPutNumber) {
        super(batteryCapacity, numberOfWorkingSpeakers, numberOfScreenCracks);
        this.outPutNumber = outPutNumber;
    }

    public void callTheNumber() {
        System.out.println("Calling the dialed number: " + outPutNumber);
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
