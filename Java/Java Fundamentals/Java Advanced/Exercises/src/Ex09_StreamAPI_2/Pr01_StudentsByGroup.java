package Ex09_StreamAPI_2;

import java.io.IOException;
import java.util.List;

public class Pr01_StudentsByGroup {
    public static void main(String[] args) throws IOException {
       List<Student> students = Reader.getStudents();

        students.stream()
                .filter(st -> st.getGroup() == 2)
                .sorted((s, s2) -> s.getFirstName().compareTo(s2.getFirstName()))
                .forEach(s -> System.out.printf("%s %s%n", s.getFirstName(), s.getLastName()));
    }
}
