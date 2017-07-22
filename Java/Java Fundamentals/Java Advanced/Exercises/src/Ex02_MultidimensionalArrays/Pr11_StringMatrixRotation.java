package Ex02_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Pr11_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<char[]> lines = new ArrayList<>();
        String[] command = scanner.nextLine().split("\\(|\\)");
        int degrees = Integer.parseInt(command[1]);

        while(true){

            String line = scanner.nextLine();
            if(line.equals("END")){
                break;
            }

            lines.add(line.toCharArray());
        }


        char[][] matrix = new char[lines.size()][];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lines.size(); i++) {
            if(lines.get(i).length > max){
                max = lines.get(i).length;
            }
        }


        for (int row = 0; row < lines.size(); row++) {
            char[] line = lines.get(row);
            matrix[row] = new char[max];
            for (int col = 0; col <line.length; col++) {
                matrix[row][col] = line[col];

            }
            if(line.length < max){
                for (int col = line.length; col < max; col++) {
                    String s = new String(new char[1]).replace("\0", " ");
                    matrix[row][col] = s.charAt(0);
                }
            }
        }

        switch (degrees % 360){
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                print90DegreesMatrix(matrix, max, lines);
                break;
            case 180:
                print180DegreeMatrix(matrix, max, lines);
                break;
            case 270:
                print270DegreeMatrix(matrix, max, lines);
                break;

        }
    }

    private static void print270DegreeMatrix(char[][] matrix, int max, ArrayList<char[]> lines) {
        for (int row = max - 1; row >=0 ; row--) {
            for (int col = 0; col < lines.size(); col++) {
                System.out.print(matrix[col][row]);
            }
            System.out.println();
        }
    }

    private static void print180DegreeMatrix(char[][] matrix, int max, ArrayList<char[]> lines) {
        for (int row = lines.size() - 1; row >= 0; row--) {
            for (int col = max - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void print90DegreesMatrix(char[][] matrix, int max, ArrayList<char[]> lines) {

        for (int row = 0; row < max; row++) {
            for (int col = 0; col < lines.size(); col++) {
                System.out.print(matrix[lines.size() - 1 - col][row]);
            }
            System.out.println();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
