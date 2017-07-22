package Lab04_SetsAndMaps;

import java.util.Scanner;
import java.util.TreeMap;

public class Pr05_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double> results = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] scores = scanner.nextLine().split(" ");
            double sumOfScores = 0;
            for (String score : scores) {
                sumOfScores += Double.parseDouble(score);
            }
            results.put(name, (sumOfScores / scores.length));
        }
        for (String key : results.keySet()) {
            System.out.println(key + " is graduated with " + results.get(key));
        }
    }
}
