package Ex06_ManualStringProccessing;

import java.util.Scanner;
import java.util.TreeSet;

public class Pr11_Palindromes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("[\\p{Punct}\\s]+");

        TreeSet<String> palindromes = new TreeSet<>();
        for (String word : input) {
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                palindromes.add(word);
            }
        }

        System.out.println(palindromes);
    }
}
