package ua.kosheleva.hw1;

public class Main {
    public static void main(String[] args) {
        //1
        String name = "Mariia";
        String lastName = "Kosheleva";
        System.out.println("\n" + name + " " + lastName);
        //2
        if(name.length() > 7){
            System.out.println("\nmore than 7");
        }
        else{
            System.out.println("\nless than 7\n");
        }
        //3
        for(int i = 0, a = 5; i <= 10; i++, a += 2){
            System.out.println("Step " + i + ", value " + a);
        }
    }
}
