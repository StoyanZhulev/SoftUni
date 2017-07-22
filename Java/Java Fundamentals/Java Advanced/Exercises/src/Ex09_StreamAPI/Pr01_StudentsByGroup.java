package Ex09_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pr01_StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

ArrayList<String> names = new ArrayList<>();
        while(true){
            String line = reader.readLine();
            if("END".equals(line)){
                break;
            }

            //if(Integer.parseInt(line[2]) == 2){
                names.add(line);
            //}
        }

        names.stream()
                .filter(n -> n.endsWith("2"))
                .sorted()
                .forEach(n -> System.out.println(n.substring(0, n.length()-2)));

//        names.stream()
//                .sorted()
//                .forEach(System.out::println);
    }
}
