package Ex09_StreamAPI_2;

import java.io.IOException;
import java.util.List;

public class Pr06_ByPhone {
    public static void main(String[] args) throws IOException {
        List<Student> students = Reader.getStudents();

        students.stream()
                .filter(s -> s.getPhone().startsWith("02") || s.getPhone().startsWith("+3592"))
                .forEach(s -> System.out.printf("%s %s %s%n", s.getFirstName(), s.getLastName(), s.getPhone()));
    }
}
