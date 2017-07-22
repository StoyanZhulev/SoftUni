package Lab01_JavaSyntax;

import java.util.Scanner;

public class Pr04_Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();

        if(firstName.isEmpty()){
            firstName = "*****";
        }

        if(secondName.isEmpty()){
            secondName = "*****";
        }

        System.out.printf("Hello, %s %s!", firstName, secondName);
    }
}
