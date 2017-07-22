package Ex09_StreamAPI_2;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Pr08_WeakStudents {
    public static void main(String[] args) throws IOException {
        List<Student> students = Reader.getStudents();

        students.stream()
                .filter(s -> s.getGrades().stream()
                        .filter(g -> g <= 3)
                        .count() >= 2)
                .sorted((s1, s2) ->
                        Integer.compare(s1.getGrades().stream().mapToInt(e -> e).sum(),
                                s2.getGrades().stream().mapToInt(e -> e).sum()
                        ))
                .forEach(s -> {
                    System.out.printf("%s %s ", s.getFirstName(), s.getLastName());
                    System.out.printf("%s %n", s.getGrades().stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
                });
    }

}
