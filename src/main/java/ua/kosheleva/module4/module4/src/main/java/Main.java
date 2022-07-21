import model.Factory;

public class Main {
    private static final Factory factory = new Factory();
    public static void main(String[] args){
        factory.greeter();
        factory.startFactoryWork();
    }
}
