package Ex09_StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr09_StudentsEnrolled {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String[]> enrolledStudents= new ArrayList<>();

        while(true){
            String[] line = reader.readLine().split(" ");
            if("END".equals(line[0])){
                break;
            }

            enrolledStudents.add(line);
        }

        enrolledStudents.stream()
                .filter(s -> s[0].endsWith("14") || s[0].endsWith("15"))
                .forEach(s -> {
                    for (int i = 1; i < s.length; i++) {
                        System.out.print(s[i] + " ");
                    }
                    System.out.println();
                });
    }
}
