package Lab02_Matrices;

import com.sun.deploy.util.ArrayUtil;

import java.util.Scanner;

public class Pr03_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");



        int[][] numbers = new int[Integer.parseInt(input[0])][Integer.parseInt(input[1])];

        for (int row = 0; row < numbers.length; row++) {
            String[] reminder = scanner.nextLine().split(", ");
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = Integer.parseInt(reminder[col]);
            }
        }

        int sumMax = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < numbers.length - 1; row++) {
            for (int col = 0; col < numbers[row].length - 1; col++) {
                int currentSum = numbers[row][col] + numbers[row][col + 1] + numbers[row + 1][col] + numbers[row + 1][col + 1];

                if(currentSum > sumMax){
                    sumMax = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println(numbers[startRow][startCol] + " " + numbers[startRow][startCol + 1]);
        System.out.println(numbers[startRow + 1][startCol] + " " + numbers[startRow + 1][startCol + 1]);
        System.out.println(sumMax);
    }
}
