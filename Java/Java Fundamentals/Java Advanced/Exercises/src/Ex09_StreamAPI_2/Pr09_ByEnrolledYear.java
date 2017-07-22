package Ex09_StreamAPI_2;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pr09_ByEnrolledYear {
    public static void main(String[] args) throws IOException {
        List<Student> students = Reader.getStudents();


        Map<Integer, List<Student>> studentsByYear = students.stream()
                .collect(Collectors.groupingBy(
                        s -> Integer.valueOf(
                                s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2))));

        studentsByYear.entrySet().stream()
                .sorted((y1, y2) -> Integer.compare(y1.getKey(), y2.getKey()))
                .forEach(y -> {
                    System.out.println("20" + y.getKey() + ":");

                    y.getValue().stream()
                            .sorted((s1, s2) -> (s1.getFirstName() + s1.getLastName()).compareTo(s2.getFirstName() + s2.getLastName()))
                            .forEach(s -> System.out.printf("-- %s %s%n", s.getFirstName(), s.getLastName()));
                });
    }
}
