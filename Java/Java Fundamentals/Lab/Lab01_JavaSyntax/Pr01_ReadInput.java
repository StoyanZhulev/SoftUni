package Lab01_JavaSyntax;

import java.util.Scanner;

public class Pr01_ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.next();
        String secondString = scanner.next();

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        scanner.nextLine();
        String thirdString = scanner.nextLine();

        int sum = num1 + num2 + num3;

        System.out.printf("%s %s %s %d", firstString, secondString, thirdString, sum);
    }

}
