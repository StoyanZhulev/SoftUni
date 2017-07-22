package Ex02_MultidimensionalArrays;

import java.util.Scanner;

public class Pr08_MatrixShiffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }

        String[] command = scanner.nextLine().split(" ");
        while(!command[0].equals("END")){
            try {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                if(!command[0].equals("swap") || command.length != 5){
                    System.out.println("Invalid input!");
                }else if(row1 < 0 || row1 > rows || col1 < 0 || col1 > cols || row2 < 0 || row2 > rows || col2 < 0 || col2 > cols){
                    System.out.println("Invalid input!");
                }else{
                    String old = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = old;

                    for (String[] strings : matrix) {
                        for (String string : strings) {
                            System.out.print(string + " ");
                        }
                        System.out.println();
                    }
                }
            } catch(Exception e){
                System.out.println("Invalid input!");
                command = scanner.nextLine().split(" ");
                continue;
            }

            command = scanner.nextLine().split(" ");
        }

    }
}
