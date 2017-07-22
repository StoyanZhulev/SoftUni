package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class Pr03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int row = 0; row < rowsAndCols; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int col = 0; col < rowsAndCols; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }

        int sum1 = 0;
        for (int row = 0; row < rowsAndCols; row++) {
            for (int col = row; col <= row; col++) {
                sum1 += matrix[row][col];
            }
        }
        int sum2 = 0;

        for (int row = 0; row < rowsAndCols; row++) {
            for (int col = rowsAndCols - 1 - row; col >= rowsAndCols - 1 - row ; col--) {
                sum2 += matrix[row][col];
            }
        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}
