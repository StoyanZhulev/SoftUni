package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class Pr05_MaximumSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int endRow = rows - 1;
        int endCol = cols - 1;
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }

        long maxSum = Long.MIN_VALUE;
        long currSum = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < rows - 2 ; row++) {
            for (int col = 0; col <cols - 2; col++) {
                currSum = calcSum(row, col, matrix);

                if(currSum > maxSum){
                    maxRow = row;
                    maxCol = col;
                    maxSum = currSum;
                }
            }
        }

        System.out.printf("Sum = %s%n", maxSum);

        for (int row = maxRow; row <= maxRow + 2 ; row++) {
            for (int col = maxCol; col <= maxCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    static int calcSum(int startRow, int startCol, int[][] matrix)
    {
        int sum = 0;
        for (int row = startRow; row < startRow + 3; row++)
        {
            for (int col = startCol; col < startCol + 3; col++)
            {
                sum = sum + matrix[row][col];
            }
        }

        return sum;
    }
}
