package Ex02_MultidimensionalArrays;


import java.util.Scanner;

public class Pr02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] palindromesMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                palindromesMatrix[row][col] = "" + (char)('a' + row) + (char)('a' + row + col) + (char)('a' + row);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(palindromesMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
