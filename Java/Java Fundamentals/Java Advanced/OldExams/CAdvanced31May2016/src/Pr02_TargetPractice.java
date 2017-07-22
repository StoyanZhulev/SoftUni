import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr02_TargetPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String snakae = reader.readLine();
        String[] shot = reader.readLine().split(" ");
        int shotRow = Integer.parseInt(shot[0]);
        int shotCol = Integer.parseInt(shot[1]);
        int radius = Integer.parseInt(shot[2]);

        for (int row = rows; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {

            }
        }
    }
}
