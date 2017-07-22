package Ex04_SetsAndMaps;

import java.util.Scanner;
import java.util.TreeSet;

public class Pr03_PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        TreeSet<String> chemicals = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] chemicalsArgs = console.nextLine().split(" ");

            for (int j = 0; j < chemicalsArgs.length; j++) {
                chemicals.add(chemicalsArgs[j]);
            }
        }

        for (String chemical : chemicals){
            System.out.printf("%s ", chemical);
        }
    }
}
