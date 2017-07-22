package Ex09_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr06_StudentsByPhone {
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
                .filter(n -> n[2].startsWith("02") || n[2].startsWith("+3592"))
                .forEach(n -> System.out.printf("%s %s%n", n[0], n[1]));
    }
}
