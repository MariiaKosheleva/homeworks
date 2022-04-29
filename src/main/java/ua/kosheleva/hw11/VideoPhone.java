package ua.kosheleva.hw11;

public class VideoPhone extends Phone {
    private final double callingTime;

    public VideoPhone(int batteryCapacity, int numberOfWorkingSpeakers, int numberOfScreenCracks, double callingTime) {
        super(batteryCapacity, numberOfWorkingSpeakers, numberOfScreenCracks);
        this.callingTime = callingTime;
    }

    public void callingWithVideo() {
        if (callingTime < 0) {
            throw new RuntimeException("Invalid value for a variable");
        } else if (callingTime > 0 && callingTime <= 20) {
            System.out.println(callingTime + " minutes of conversation. You still have a lot of time to talk. Don't worry!");
        } else if (callingTime > 20 && callingTime <= 40) {
            System.out.println(callingTime + " minutes of conversation. You should end the conversation and get ready for work.");
        } else {
            System.out.println(callingTime + " minutes of conversation. You're already late for work, do what you want!");
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
