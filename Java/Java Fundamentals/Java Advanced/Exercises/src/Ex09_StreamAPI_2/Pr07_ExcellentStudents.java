package Ex09_StreamAPI_2;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Pr07_ExcellentStudents {
    public static void main(String[] args) throws IOException {
        List<Student> students = Reader.getStudents();

        students.stream()
                .filter(s -> s.getGrades().contains(Integer.valueOf("6")))
                .forEach(s -> {
                    System.out.printf("%s %s ", s.getFirstName(), s.getLastName());
                    s.getGrades().stream().sorted((g1, g2) -> g2.compareTo(g1))
                            .forEach(g -> System.out.printf("%s ", g));
                    System.out.println();
                });
    }
}
