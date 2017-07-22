package Ex06_ManualStringProccessing;

import java.util.Scanner;

public class Pr12_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstAndSecond = scan.nextLine().split(" ");
        String first = firstAndSecond[0];
        String second = firstAndSecond[1];
        first.toCharArray();
        second.toCharArray();

        int minLength = Math.min(first.length(), second.length());
        int maxLength = Math.max(first.length(), second.length());

        int sum = 0;

        for (int i = 0; i < minLength; i++) {
            sum += (int)(first.charAt(i) * second.charAt(i));
        }

        if(first.length() > second.length()){
            for (int i = minLength; i < maxLength; i++) {
                sum += (int)(first.charAt(i));
            }
        }else if(second.length() > first.length()){
            for (int i = minLength; i < maxLength; i++) {
                sum += (int)(second.charAt(i));
            }
        }

        System.out.println(sum);
    }
}
