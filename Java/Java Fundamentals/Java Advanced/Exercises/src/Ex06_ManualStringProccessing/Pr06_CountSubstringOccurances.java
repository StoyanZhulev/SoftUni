package Ex06_ManualStringProccessing;

import java.util.Scanner;

public class Pr06_CountSubstringOccurances {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        String searchedWord = scanner.nextLine().toLowerCase();

        int count = 0;
        int index = input.indexOf(searchedWord);
        while (index != -1){
            count++;
            index = input.indexOf(searchedWord, index + 1);
        }

        System.out.println(count);
    }
}
