package Pr05_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String input = reader.readLine();

        while (!"END".equals(input)){
            String[] inArgs = input.split(" ");
            Person person = new Person(inArgs[0], Integer.parseInt(inArgs[1]), inArgs[2]);
            people.add(person);

            input = reader.readLine();
        }

        int equalPeople = 0;
        int nonEqual = 0;
        int allPeople = people.size();

        int n = Integer.parseInt(reader.readLine());

        Person person = people.get(n - 1);

        for (Person p : people) {
            if(person.compareTo(p) == 0){
                equalPeople++;
            }else {
                nonEqual++;
            }
        }

        if(equalPeople == 1){
            System.out.println("No matches");
        }else{
            System.out.printf("%s %s %s", equalPeople, nonEqual, allPeople);
        }
    }
}
