package Lab02_Matrices;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Pr01_ReadSortAndPrintArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String[] array = new String[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLine();
        }

        Arrays.sort(array);
        //Collections.reverse(Arrays.asList(array));

        for (String string : array) {
            System.out.println(string);
        }
    }
}
