package Ex06_ManualStringProccessing;

import java.util.Locale;
import java.util.Scanner;

public class Pr14_LettersChangeNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scn = new Scanner(System.in);
        String[] input = scn.nextLine().split("\\s+");
        double totalSum  = 0;
        for (int i = 0; i < input.length; i++) {
            double result = 0;
            int number = Integer.parseInt(input[i].substring(1, input[i].length() - 1));
            char firstLetter = input[i].charAt(0);
            char lastLetter = input[i].charAt(input[i].length() - 1);
            if (firstLetter >= 'A' && firstLetter <= 'Z') {
                result = (double)number / (firstLetter % ('A' - 1));
            }
            else {
                result = (double)number * (firstLetter % ('a' - 1));
            }
            if (lastLetter >= 'A' && lastLetter <= 'Z') {
                result -= (lastLetter % ('A' - 1));
            } else {
                result += (lastLetter % ('a' - 1));
            }
            totalSum += result;
        }
        System.out.printf("%.2f", totalSum);
    }
}
