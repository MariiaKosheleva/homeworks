package ua.kosheleva.hw2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the coordinates of the 1st point: ");
        double x1 = in.nextInt();
        double y1 = in.nextInt();
        System.out.println("Input the coordinates of the 2nd point: ");
        double x2 = in.nextInt();
        double y2 = in.nextInt();
        System.out.println("Input the coordinates of the 3rd point: ");
        double x3 = in.nextInt();
        double y3 = in.nextInt();
        System.out.printf("Triangle square is " + "%.2f", (method2(x1,y1,x2,y2,x3,y3)));

    }
    public static double method2(double a1, double b1, double a2,
                                 double b2, double a3, double b3){
        double square = 0;
        double a = Math.sqrt((a1-a2)*(a1-a2) + (b1-b2)*(b1-b2));
        double b = Math.sqrt((a1-a3)*(a1-a3) + (b1-b3)*(b1-b3));
        double c = Math.sqrt((a2-a3)*(a2-a3) + (b2-b3)*(b2-b3));
        if (a + b <= c || a + c <= b){
            System.out.println("Треугольник не существует");
        }
        else {
            double p = (a + b + c) / 2.0;
            square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return (square);
    }
}
