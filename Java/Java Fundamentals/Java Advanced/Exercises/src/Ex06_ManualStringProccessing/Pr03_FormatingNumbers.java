package Ex06_ManualStringProccessing;

import java.io.IOException;
import java.util.Scanner;

public class Pr03_FormatingNumbers {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int numA = Integer.parseInt(scanner.next());
        double numB = Double.parseDouble(scanner.next());
        double numC = Double.parseDouble(scanner.next());

        String binary = Integer.toBinaryString(numA);
        while (binary.length() < 10){
            binary = "0" + binary;
        }
        if (binary.length() > 10){
            binary = binary.substring(0, 10);
        }
        sb.append("|").append(String.format("%-10X", numA));
        sb.append("|").append(String.format("%s", binary));
        sb.append("|").append(String.format("%10.2f", numB));
        sb.append("|").append(String.format("%-10.3f", numC)).append("|");
        System.out.println(sb);
    }
}
