package Ex08_FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class Pr01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");

        Consumer<String> print =  name -> System.out.println(name);

        for (String name : names) {
            print.accept(name);
        }
    }
}
