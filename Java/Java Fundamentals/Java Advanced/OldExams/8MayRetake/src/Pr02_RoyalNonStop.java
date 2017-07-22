import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Pr02_RoyalNonStop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dim = reader.readLine().split(" ");

        String[] prices = reader.readLine().split(" ");
        double lukankaPrice = Double.parseDouble(prices[0]);
        double rakijaPrice = Double.parseDouble(prices[1]);


        String line = reader.readLine();
        BigDecimal totalSum = BigDecimal.ZERO;
        int costumers = 0;
        while (!"Royal Close".equals(line)) {
            BigDecimal currSum = BigDecimal.ZERO;
            String[] costumer = line.split(" ");
            int costumerRow = Integer.parseInt(costumer[0]);
            int costumerCol = Integer.parseInt(costumer[1]);

            if (costumerRow < costumerCol) {
                while (costumerRow >= 0) {
                    currSum = getCurrSum(costumerRow, costumerCol, lukankaPrice, rakijaPrice, currSum);
                    costumerRow--;
                }
                costumerRow = 0;
                costumerCol--;
                while (costumerCol > 0) {
                    currSum = getCurrSum(costumerRow, costumerCol, lukankaPrice, rakijaPrice, currSum);
                    costumerCol--;
                }
            } else {

                while (costumerCol >= 0) {
                    currSum = getCurrSum(costumerRow, costumerCol, lukankaPrice, rakijaPrice, currSum);
                    costumerCol--;
                }

                costumerCol = 0;
                costumerRow--;
                while (costumerRow > 0) {
                    currSum = getCurrSum(costumerRow, costumerCol, lukankaPrice, rakijaPrice, currSum);
                    costumerRow--;
                }

            }
            totalSum = totalSum.add(currSum);
            costumers++;

            line = reader.readLine();
        }

        System.out.printf("%.6f%n", totalSum);
        System.out.println(costumers);
    }

    public static BigDecimal getCurrSum(int costumerRow, int costumerCol, double lukankaPrice, double rakijaPrice, BigDecimal currSum) {
        BigDecimal rowValue = new BigDecimal(costumerRow + 1);
        BigDecimal colValue = new BigDecimal(costumerCol + 1);
        if (costumerRow % 2 == 0) {
            BigDecimal productPrice = new BigDecimal(lukankaPrice);
            BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);
            currSum = currSum.add(productSum);
        } else {
            BigDecimal productPrice = new BigDecimal(rakijaPrice);
            BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);
            currSum = currSum.add(productSum);
        }
        return currSum;
    }

}
