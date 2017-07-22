package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class Pr04_2x2SquareInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] array = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = array[col];
            }
        }

        int count = 0;
        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if(matrix[row][col].equals(matrix[row][col + 1]) && matrix[row - 1][col].equals(matrix[row - 1][col + 1]) && matrix[row][col].equals(matrix[row - 1][col + 1])){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
