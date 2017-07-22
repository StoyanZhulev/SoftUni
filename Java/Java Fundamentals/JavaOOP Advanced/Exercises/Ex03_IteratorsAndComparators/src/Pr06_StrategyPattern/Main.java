package Pr06_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        PeopleNameComparator peopleNameComparator = new PeopleNameComparator();
        PeopleAgeComparator peopleAgeComparator = new PeopleAgeComparator();

        TreeSet<Person> peopleByName = new TreeSet<>(peopleNameComparator);
        TreeSet<Person> peopleByAge = new TreeSet<>(peopleAgeComparator);
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            Person person = new PersonImpl(line[0], Integer.parseInt(line[1]));
            peopleByName.add(person);
            peopleByAge.add(person);
        }


        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);

//        peopleByName.stream()
//                .sorted(peopleNameComparator)
//                .forEach(System.out::println);
//
//        peopleByAge.stream()
//                .sorted(peopleAgeComparator)
//                .forEach(System.out::println);

    }
}
