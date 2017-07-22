package Ex04_SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Pr01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.valueOf(console.nextLine());

        LinkedHashSet<String> names = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            names.add(console.nextLine());
        }

        for (String name : names){
            System.out.println(name);
        }
    }
}
