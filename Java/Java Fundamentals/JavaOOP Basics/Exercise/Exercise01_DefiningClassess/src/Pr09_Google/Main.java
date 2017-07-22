package Pr09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> people = new HashMap<>();

        String input = reader.readLine();

        while (!"End".equals(input)){
            String[] inputArgs = input.split(" ");
            String personName = inputArgs[0];
            String propertyType = inputArgs[1];

            switch (propertyType){
                case "company":
                    String companyName = inputArgs[2];
                    String department = inputArgs[3];
                    String salary = inputArgs[4];
                    Company company = new Company(companyName, department, salary);
                    updateProperty(personName, company, people);
                    break;
                case "car":
                    String model = inputArgs[2];
                    String speed = inputArgs[3];
                    Car car = new Car(model, speed);
                    updateProperty(personName, car, people);
                    break;
                case "parents":
                    String parentName = inputArgs[2];
                    String parentBday = inputArgs[3];
                    Parent parent = new Parent(parentName, parentBday);
                    addProperty(personName, parent, people);
                    break;
                case "pokemon":
                    String pokemonName = inputArgs[2];
                    String pokemonType = inputArgs[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    addProperty(personName, pokemon, people);
                    break;
                case "children":
                    String childName = inputArgs[2];
                    String childbDay = inputArgs[3];
                    Child child = new Child(childName, childbDay);
                    addProperty(personName, child, people);
            }
            input = reader.readLine();
        }

        String name = reader.readLine();

        System.out.println(people.get(name));
    }

    private static void addProperty(String personName, Object object, HashMap<String, Person> people) {
        if(people.containsKey(personName)){
            people.get(personName).addProperty(object);
        }else{
            Person person = new Person(personName);
            person.addProperty(object);
            people.put(personName, person);
        }
    }

    private static void updateProperty(String personName, Object object, HashMap<String, Person> people) {
        if(people.containsKey(personName)){
            people.get(personName).updateProperty(object);
        }else{
            Person person = new Person(personName);
            person.updateProperty(object);
            people.put(personName, person);
        }
    }
}
