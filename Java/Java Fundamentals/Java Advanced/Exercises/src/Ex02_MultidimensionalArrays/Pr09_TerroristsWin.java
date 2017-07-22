package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class Pr09_TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        String input = scanner.nextLine();

        int firstIndex = input.indexOf('|');
        int lastIndx = 0;
        int sum = 0;
        int power = 0;

        while (firstIndex != -1) {
            lastIndx = input.indexOf('|', firstIndex + 1);

            for (int j = firstIndex + 1; j < lastIndx; j++) {
                sum += (int) input.charAt(j);

            }
            power = sum % 10;

            int start = Math.max(0, firstIndex - power);
            int end = Math.min(input.length() - 1, lastIndx + power);

            String toBeReplaced = input.substring(start, end +1);
            input = input.replace(toBeReplaced, new String(new char[toBeReplaced.length()]).replace("\0", "."));

            firstIndex = input.indexOf('|', lastIndx + 1);
            sum = 0;
        }

        System.out.println(input);
    }
}
