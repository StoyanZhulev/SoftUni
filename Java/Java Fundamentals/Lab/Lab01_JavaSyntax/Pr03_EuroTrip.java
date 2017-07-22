package Lab01_JavaSyntax;


import java.math.BigDecimal;
import java.util.Scanner;

public class Pr03_EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = scanner.nextDouble();

        double pricePerKilo = 1.20;

        BigDecimal priceInLeva = new BigDecimal(quantity * pricePerKilo);
        BigDecimal rate = new BigDecimal("4210500000000");


        BigDecimal price = rate.multiply(priceInLeva);

        System.out.printf("%.2f marks", price);
    }
}
