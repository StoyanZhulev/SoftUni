package Ex09_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr04_SortStudents {
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
                .sorted((n1, n2) -> n2[0].compareTo(n1[0]))
                .sorted((n1, n2) -> n1[1].compareTo(n2[1]))
                .forEach(n -> System.out.printf("%s %s%n", n[0], n[1]));
    }
}
