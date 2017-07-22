package Lab01_JavaSyntax;

import java.util.Scanner;

public class Pr09_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();

        double height = scanner.nextDouble();

        System.out.printf("Area = %.2f", calculateTriangleArea(base, height));
    }

    public static double calculateTriangleArea(double base, double height){
        double area = base * height / 2;
        return area;
    }

}
