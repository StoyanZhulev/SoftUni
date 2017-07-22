import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr02_JediGalaxy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dim = reader.readLine().split(" ");
        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        int[][] matrix = new int[rows][cols];

        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = count;
                count++;
            }
        }

        long ivoSum = 0;
        String input = reader.readLine();
        while (!"Let the Force be with you".equals(input)) {
            String[] ivoSpot = input.split(" ");
            int ivoRow = Integer.parseInt(ivoSpot[0]);
            int ivoCol = Integer.parseInt(ivoSpot[1]);

            String[] evilSpot = reader.readLine().split(" ");
            int evilRow = Integer.parseInt(evilSpot[0]);
            int evilCol = Integer.parseInt(evilSpot[1]);

            while (rows - 1 < ivoRow || ivoCol < 0) {
                ivoRow--;
                ivoCol++;
            }

            while (rows - 1 < evilRow || evilCol > cols - 1) {
                evilRow--;
                evilCol--;
            }

            while (evilRow >= 0 && evilCol >= 0) {
                matrix[evilRow][evilCol] = 0;
                evilRow--;
                evilCol--;
            }

            while(ivoRow >= 0 && ivoCol <= cols - 1){
                ivoSum += matrix[ivoRow][ivoCol];
                ivoRow--;
                ivoCol++;
            }

            input = reader.readLine();
        }

        System.out.println(ivoSum);
    }
}
