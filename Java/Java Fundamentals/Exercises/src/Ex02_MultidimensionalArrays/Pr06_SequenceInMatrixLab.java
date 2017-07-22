package Ex02_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pr06_SequenceInMatrixLab {
    private static int SEQUENCE_COUNT = 0;
    private static String SEQUENCE_SYMBOL = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dim = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        String[][] matrix = new String[rows][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        List<String> sequence = new ArrayList<>();

        //line
        for (int row = 0; row < matrix.length; row++) {
            sequence.addAll(Arrays.asList(matrix[row]));
            checkForSequence(sequence);
        }

        //column
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                sequence.add(matrix[row][col]);
            }

            checkForSequence(sequence);
        }

        //diagonal
        int diagSize = Math.min(rows, cols);
        for (int i = 0; i < diagSize; i++) {
            sequence.add(matrix[i][i]);
        }
        checkForSequence(sequence);

        for (int i = 0; i < SEQUENCE_COUNT; i++) {
            System.out.printf("%s, ", SEQUENCE_SYMBOL);
        }
    }

    private static void checkForSequence(List<String> sequence) {
        for (int startPos = 0; startPos < sequence.size() - 1; startPos++) {
            int counter = 1;
            int currPos = startPos + 1;
            String symbol = sequence.get(startPos);
            while (symbol.equals(sequence.get(currPos))){
                counter++;
                if(counter >= SEQUENCE_COUNT){
                    SEQUENCE_COUNT = counter;
                    SEQUENCE_SYMBOL = symbol;
                }
                currPos++;
                if(currPos >= sequence.size()){
                    break;
                }
            }
            startPos = currPos - 1;
        }

        sequence.clear();
    }
}
