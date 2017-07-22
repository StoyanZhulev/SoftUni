package Ex09_StreamAPI_2;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Pr04_SortStudents {
    public static void main(String[] args) throws IOException {
        List<Student> students = Reader.getStudents();

        Comparator<Student> lastAscending =
                (s1, s2) -> s1.getLastName().compareTo(s2.getLastName());

        Comparator<Student> studentComparator = lastAscending.thenComparing((s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName()));


        students.stream()
                //.sorted((s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName()))
                //.sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
                .sorted(studentComparator)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }
}
