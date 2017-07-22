package Ex06_ManualStringProccessing;

import java.util.Scanner;

public class Pr02_StringLength {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();

        if (input.length() < 20) {
            String output = input + new String(new char[20 - input.length()]).replace("\0", "*");

            System.out.println(output);
        } else if (input.length() > 20) {
            String output = input.substring(0, 20);
            System.out.println(output);
        } else {
            System.out.println(input);
        }
    }
}
