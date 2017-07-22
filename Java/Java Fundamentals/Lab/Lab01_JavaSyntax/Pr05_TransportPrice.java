package Lab01_JavaSyntax;

import java.util.Scanner;

public class Pr05_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double kilometers = scanner.nextDouble();
        String timeOfDay = scanner.next();

        double totalPrice = 0;
        if(kilometers < 20){
            if(timeOfDay.equals("day")){
                totalPrice = 0.7 + kilometers * 0.79;
            }else{
                totalPrice = 0.7 + kilometers * 0.9;
            }
        }else if(kilometers >= 20 && kilometers < 100){
            totalPrice = kilometers * 0.09;
        }else{
            totalPrice = kilometers * 0.06;
        }

        System.out.printf("%.2f", totalPrice);
    }
}
