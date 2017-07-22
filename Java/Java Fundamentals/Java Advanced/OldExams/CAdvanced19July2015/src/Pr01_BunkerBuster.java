import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr01_BunkerBuster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = reader.readLine().split(" ");

            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        int destroyedCells = 0;

        String input = reader.readLine();
        while(!"cease fire!".equals(input)){
            String[] inputArgs = input.split(" ");

            int row = Integer.parseInt(inputArgs[0]);
            int col = Integer.parseInt(inputArgs[1]);
            char bomb = inputArgs[2].charAt(0);
            int power = (int)bomb;
            int halfDamage = (int)Math.ceil(power / 2.0);

            try{
                matrix[row][col] -= power;


                matrix[row][col-1] -= halfDamage;

            }
            catch (Exception e){

            }

            try{
                matrix[row][col+1] -= halfDamage;

            }
            catch (Exception e){

            }
            try{
                matrix[row - 1][col] -= halfDamage;

            }
            catch (Exception e){

            }

            try{
                matrix[row + 1][col] -= halfDamage;

            }
            catch (Exception e){

            }
            try{
                matrix[row - 1][col-1] -= halfDamage;

            }
            catch (Exception e){

            }
            try{
                matrix[row - 1][col+1] -= halfDamage;

            }
            catch (Exception e){

            }

            try{
                matrix[row + 1][col-1] -= halfDamage;

            }
            catch (Exception e){

            }
            try{
                matrix[row + 1][col+1] -= halfDamage;

            }
            catch (Exception e){

            }

            input = reader.readLine();
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(matrix[row][col] <= 0){
                    destroyedCells++;
                }
            }
        }

        System.out.println("Destroyed bunkers: " + destroyedCells);
        double damageDone = (double)destroyedCells / (rows * cols) * 100.0;
        System.out.printf("Damage done: %.1f", damageDone);
        System.out.println(" %");
    }
}
