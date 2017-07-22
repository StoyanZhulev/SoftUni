package Ex09_StreamAPI_2;

import java.io.IOException;
import java.util.List;

public class Pr05_ByEmailDomain {
    public static void main(String[] args) throws IOException {
        List<Student> students = Reader.getStudents();

        students.stream()
                .filter(s -> s.getEmail().endsWith("@gmail.com"))
                .forEach(s -> System.out.printf("%s %s %s%n", s.getFirstName(), s.getLastName(), s.getEmail()));
    }
}
