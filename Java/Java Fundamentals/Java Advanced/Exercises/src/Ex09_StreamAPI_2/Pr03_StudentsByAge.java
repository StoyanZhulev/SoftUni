package Ex09_StreamAPI_2;

import java.io.IOException;
import java.rmi.StubNotFoundException;
import java.util.List;

public class Pr03_StudentsByAge {
    public static void main(String[] args) throws IOException {
        List<Student> students = Reader.getStudents();

        students.stream()
                .filter(s -> 18 <= s.getAge() && s.getAge() <= 24)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getAge()));
    }
}
