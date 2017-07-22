package Ex06_ManualStringProccessing;

import java.util.HashMap;
import java.util.Scanner;

public class Pr13_MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split(" ");
        String firstWord = words[0];
        String secondWord = words[1];

        HashMap<Character, Character> map = new HashMap<>();

        int length = Math.min(firstWord.length(), secondWord.length());
        for (int i = 0; i < length; i++) {
            if(!map.containsKey(firstWord.charAt(i))){
                if(map.containsValue(secondWord.charAt(i))){
                    System.out.println("false");
                    return;
                }
                map.put(firstWord.charAt(i), secondWord.charAt(i));
            }else {
                if(map.get(firstWord.charAt(i)) != secondWord.charAt(i)){
                    System.out.println("false");
                    return;
                }
            }
        }

        if(firstWord.length() == secondWord.length()){
            System.out.println("true");
            return;
        }

        String substring = "";

        if(firstWord.length() > secondWord.length()){
            substring = firstWord.substring(length);
        }else{
            substring = secondWord.substring(length);
        }

        for (int i = 0; i < substring.length(); i++) {
            if(map.values().contains(substring.charAt(i)) || map.keySet().contains(substring.charAt(i))){
                System.out.println("true");
                return;
            }else {
                System.out.println("false");
                return;
            }
        }

    }
}
