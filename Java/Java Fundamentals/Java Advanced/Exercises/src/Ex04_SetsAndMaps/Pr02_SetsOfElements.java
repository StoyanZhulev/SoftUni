package Ex04_SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Pr02_SetsOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = console.nextInt();
        int m = console.nextInt();
        console.nextLine();

        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            set1.add(Integer.parseInt(console.nextLine()));
        }

        for (int i = 0; i < m; i++) {
            set2.add(Integer.parseInt(console.nextLine()));
        }

        set1.retainAll(set2);

        for (Integer num : set1){
            System.out.printf("%s ", num);
        }
    }
}
