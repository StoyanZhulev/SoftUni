package Lab06_ManualStringProccessing;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr01_StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> results = new TreeMap<>();
        for (int i = 0; i < number; i++) {
            String[] inputArgs = scanner.nextLine().split(" - ");
            String[] examResultsAsString = inputArgs[1].split(", ");

            List<Double> examResults = new ArrayList<>();
            double sum = 0;
            for (String res : examResultsAsString) {
                examResults.add(Double.parseDouble(res));
                sum += Double.parseDouble(res);
            }
            examResults.add(sum / 3);

            results.put(inputArgs[0], examResults);
        }
        if (number != 0) {
            System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
            for (String s : results.keySet()) {
                System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", s, results.get(s).get(0), results.get(s).get(1), results.get(s).get(2), results.get(s).get(3)).replace(".", ","));
            }
        }
    }
}
