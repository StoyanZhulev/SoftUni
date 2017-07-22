package Ex09_StreamAPI_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Reader {
    public static List<Student> getStudents() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(Reader.class.getResourceAsStream("/StudentData.txt")));

        String line = "";

        List<String> inputData = new ArrayList<>();
        while((line = reader.readLine())  != null){
            inputData.add(line);
        }

        List<Student> students = new ArrayList<>();
        for (int i = 1; i < inputData.size(); i++) {
            String[] tokens = inputData.get(i).split("\\s");

            String facultyNumber = tokens[0];
            String firstName = tokens[1];
            String lastName = tokens[2];
            String email = tokens[3];
            Integer age = Integer.parseInt(tokens[4]);
            Integer group = Integer.parseInt(tokens[5]);
            List<Integer> grades = new ArrayList<>();
            Stream.of(tokens).skip(6).limit(4).mapToInt(Integer::parseInt).forEach(grades::add);
            String phone = tokens[tokens.length - 1];

            Student student = new Student(facultyNumber, firstName, lastName, email, age, group, grades, phone);
            students.add(student);
        }

        return students;
    }
}
