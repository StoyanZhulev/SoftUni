package Lab01_JavaSyntax;

import java.util.Scanner;

public class Pr02_AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        double third = scanner.nextDouble();

        double sum = (first + second + third) / 3;

        System.out.printf("%.2f", sum);
    }
}
