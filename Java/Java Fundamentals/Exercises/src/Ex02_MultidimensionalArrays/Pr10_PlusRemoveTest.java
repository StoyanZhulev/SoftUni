package Ex02_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Pr10_PlusRemoveTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> finalList = new ArrayList<>();

        while(true){
            String input = scanner.nextLine();

            if(input.equals("END")){
                break;
            }

            lines.add(input);
            finalList.add(input);
        }

        for (int i = 0; i < lines.size() - 2; i++) {
            String firstLine = lines.get(i);
            String secondLine = lines.get(i + 1);
            String thirdLine = lines.get(i + 2);

            int length1 = firstLine.length();
            int length2 = secondLine.length();
            int length3 = thirdLine.length();

            for (int j = 1; j < Math.min(Math.min(length1, length2), length3); j++) {
                boolean isPlus = isPlusFormed(j, firstLine, secondLine, thirdLine);

                if(isPlus){
                   updateFinalList(finalList, i, j);
                }
            }
        }
       printFinalList(finalList);
    }

    private static void printFinalList(ArrayList<String> finalList) {
        for (int i = 0; i < finalList.size(); i++) {
            finalList.set(i, finalList.get(i).replace("R", ""));
            System.out.println(finalList.get(i));
        }
    }

    private static void updateFinalList(ArrayList<String> finalList, int i, int j) {
        char[] charArray = finalList.get(i).toCharArray();
        charArray[j] = 'R';
        finalList.set(i, String.valueOf(charArray));

        charArray = finalList.get(i + 1).toCharArray();
        charArray[j - 1] = 'R';
        charArray[j] = 'R';
        charArray[j + 1] = 'R';
        finalList.set(i + 1, String.valueOf(charArray));

        charArray = finalList.get(i + 2).toCharArray();
        charArray[j] = 'R';
        finalList.set(i + 2, String.valueOf(charArray));
    }


    private static boolean isPlusFormed(int j, String firstLine, String secondLine, String thirdLine) {

        String upper = firstLine.substring(j, j + 1).toLowerCase();
        String middlePartExpect = new String(new char[3]).replace("\0", upper);
        String middle = "";
        if(j + 2 > secondLine.length()){
            middle = secondLine.substring(j - 1, secondLine.length()).toLowerCase();
        }else{
             middle = secondLine.substring(j - 1, j + 2).toLowerCase();
        }
        String bottom = thirdLine.substring(j, j + 1).toLowerCase();

        return upper.equals(bottom) && middle.equals(middlePartExpect);
    }
}
