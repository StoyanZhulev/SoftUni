package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class Pr01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        if(pattern.equals("A")){
            patternAMatrix(n);
        }else{
            patternBMatrix(n);
        }
    }

    private static void patternBMatrix(int n) {
        int[][] matrix = new int[n][n];

        int index = 1;

        for (int col = 0; col < n; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = index;
                    index++;
                }
            }else{
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = index;
                    index++;
                }
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void patternAMatrix(int n) {
        int[][] matrix = new int[n][n];

        int index = 1;

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = index;
                index++;
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
