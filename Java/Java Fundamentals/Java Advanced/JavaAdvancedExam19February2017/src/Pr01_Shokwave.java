import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr01_Shokwave {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dim = reader.readLine().split(" ");

        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);
         long[][] matrix = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }

        String line = reader.readLine();

        while(!"Here We Go".equals(line)){
            String[] lineArgs = line.split(" ");
            int x1 = Integer.parseInt(lineArgs[0]);
            int y1 = Integer.parseInt(lineArgs[1]);
            int x2 = Integer.parseInt(lineArgs[2]);
            int y2 = Integer.parseInt(lineArgs[3]);

            for (int row = x1; row <= x2; row++) {
                for (int col = y1; col <= y2; col++) {
                    matrix[row][col]+= 1;
                }
            }
            line = reader.readLine();
        }


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}
