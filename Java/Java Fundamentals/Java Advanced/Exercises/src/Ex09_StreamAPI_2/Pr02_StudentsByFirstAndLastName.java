package Ex09_StreamAPI_2;

import java.io.IOException;
import java.util.List;

public class Pr02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        List<Student> students = Reader.getStudents();

        students.stream()
                .filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }
}
