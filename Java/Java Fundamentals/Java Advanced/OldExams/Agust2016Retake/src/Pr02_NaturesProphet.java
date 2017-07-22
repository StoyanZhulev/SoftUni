import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pr02_NaturesProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }

        ArrayList<String> plants = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if ("Bloom Bloom Plow".equals(line)) {
                break;
            }

            String[] lineArgs = line.split(" ");
            int row = Integer.parseInt(lineArgs[0]);
            int col = Integer.parseInt(lineArgs[1]);

           matrix[row][col] = 1;

           plants.add(line);
        }

        Collections.sort(plants);
        for (int i = 0; i < plants.size(); i++) {
            String[] line = plants.get(i).split(" ");
            int row = Integer.parseInt(line[0]);
            int col = Integer.parseInt(line[1]);

            for (int currCol = col + 1; currCol < cols; currCol++) {
                matrix[row][currCol] = matrix[row][currCol] + 1;
            }
            for (int currCol = col - 1; currCol >= 0; currCol--) {
                matrix[row][currCol] = matrix[row][currCol] + 1;
            }

            for (int currRow = row + 1; currRow < rows; currRow++) {
                matrix[currRow][col] = matrix[currRow][col] + 1;
            }
            for (int currRow = row-1; currRow >= 0 ; currRow--) {
                matrix[currRow][col] = matrix[currRow][col] + 1;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
