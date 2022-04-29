package ua.kosheleva.hw11;

public class SmartPhone extends Phone {
    private int sms = 0;

    public SmartPhone(int batteryCapacity, int numberOfWorkingSpeakers, int numberOfScreenCracks, int sms) {
        super(batteryCapacity, numberOfWorkingSpeakers, numberOfScreenCracks);
        this.sms = sms;
    }

    public void checkNewSms() {
        if (sms < 0) {
            throw new RuntimeException("Invalid value for a variable");
        } else if (sms == 0) {
            System.out.println("You have no new sms!");
        } else if (sms < 10) {
            System.out.println("You have some new sms! (" + sms + ")");
        } else {
            System.out.println("You have a lot of new sms! (" + sms + ")");
        }
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


