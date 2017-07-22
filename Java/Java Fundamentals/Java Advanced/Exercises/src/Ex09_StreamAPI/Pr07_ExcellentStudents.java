package Ex09_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr07_ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String[]> names = new ArrayList<>();
        while(true){
            String[] line = reader.readLine().split(" ");
            if("END".equals(line[0])){
                break;
            }

            names.add(line);
        }


        names.stream()
                .filter(n -> hasExcellent(n))
                .forEach(n -> System.out.printf("%s %s%n", n[0], n[1]));
    }

    private static boolean hasExcellent(String[] n) {

        for (String s : n) {
            if(Character.isDigit(s.toCharArray()[0])){
                if(s.toCharArray()[0] == '6'){
                    return true;
                }
            }
        }
        return false;
    }
}
