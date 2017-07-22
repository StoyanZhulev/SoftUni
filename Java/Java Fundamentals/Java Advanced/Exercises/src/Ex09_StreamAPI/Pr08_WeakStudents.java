package Ex09_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr08_WeakStudents {
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
                .filter(n -> isWeak(n))
                .forEach(n -> System.out.printf("%s %s%n", n[0], n[1]));
    }

    private static boolean isWeak(String[] n) {


        int count = 0;
        for (String s : n) {
            if(Character.isDigit(s.toCharArray()[0])){
                if(s.toCharArray()[0] <= '3'){
                   count++;
                    if(count == 2){
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
