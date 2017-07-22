package Ex08_FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class Pr02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = name -> System.out.println("Sir " + name);

        String[] names = scanner.nextLine().split("\\s+");

        for (String name : names) {
            print.accept(name);
        }
    }
}
