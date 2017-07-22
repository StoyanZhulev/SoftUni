package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class Pr06_SequenceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] strings = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = strings[col];
            }
        }

        int count = 0;
        int maxSeq = 0;
        String maxValue = "";

        //horizontal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols -1; col++) {
                if(matrix[row][col].equals(matrix[row][col + 1])){
                    count++;
                }else{
                    count = 1;
                }



                if(count >= maxSeq){
                    maxSeq = count;
                    maxValue = matrix[row][col];
                }
            }
            count = 1;

        }

        //vertical
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 1; row++) {
                if(matrix[row][col].equals(matrix[row + 1][col])){
                    count++;
                }else{
                    count = 1;
                }

                if(count >= maxSeq){
                    maxSeq = count;
                    maxValue = matrix[row][col];
                }
            }
            count = 1;
        }

        // left to right diagonal
        for (int row = 0, col = 0; row < rows - 1 && col < cols - 1; row++, col++) {
            if(matrix[row][col].equals(matrix[row + 1][col + 1])){
                count++;
            }else{
                count = 1;
            }

            if(count >= maxSeq){
                maxSeq = count;
                maxValue = matrix[row][col];
            }
        }
        count = 1;

        //right to left diagonal
        for (int row = 0, col = cols - 1; row < rows - 1 && col > 0; row++, col--) {
            if(matrix[row][col].equals(matrix[row + 1][col - 1])){
                count++;
            }else{
                count = 1;
            }
            if(count >= maxSeq){
                maxSeq = count;
                maxValue = matrix[row][col];
            }
        }

        for (int i = 0; i < maxSeq; i++) {
            System.out.printf("%s, ", maxValue);
        }
    }
}
