package Ex09_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr02_StudentsByFirstAndLastName {
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
                .filter(n -> n[0].compareTo(n[1]) < 0)
                .forEach(n -> System.out.printf("%s %s%n", n[0], n[1]));
    }
}
