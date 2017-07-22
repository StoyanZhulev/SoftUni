package Ex04_SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr04_CountSymbols {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            if(!symbols.containsKey(charAt)){
                symbols.put(charAt, 1);
            }else{
                symbols.put(charAt, symbols.get(charAt) + 1);
            }
        }

        for (Map.Entry entry : symbols.entrySet()){
            System.out.printf("%s: %s time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
