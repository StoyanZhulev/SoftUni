package Pr10_FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String line = bf.readLine();
//        String personName = !line.contains("/") ? line : "";
//        String personBirthday = line.contains("/") ? line : "";
//        Person personWanted = new Person(personName, personBirthday);
//
//        List<Person> fullDataPeople = new ArrayList<>();
//        List<Person> halfDataPeople = new ArrayList<>();
//
//        while (!(line = bf.readLine()).equals("End")) {
//            String[] input = line.split(" - ");
//            switch (input.length) {
//                case 1:
//                    String[] newSplit = line.split("\\s+");
//                    String name = newSplit[0] + " " + newSplit[1];
//                    String birthday = newSplit[2];
//                    fullDataPeople.add(new Person(name, birthday));
//                    break;
//                case 2:
//                    String nameOrBirthdayParent = input[0];
//                    String nameOrBirthdayChild = input[1];
//                    Person parent = nameOrBirthdayParent.contains("/") ? new Person("", nameOrBirthdayParent) :
//                            new Person(nameOrBirthdayParent, "");
//                    Person child = nameOrBirthdayChild.contains("/") ? new Person("", nameOrBirthdayChild) :
//                            new Person(nameOrBirthdayChild, "");
//                    parent.addChild(child);
//                    child.addParent(parent);
//                    halfDataPeople.add(parent);
//                    halfDataPeople.add(child);
//                    break;
//            }
//        }
//        halfDataPeople.forEach(partialPerson -> {
//            fullDataPeople.stream().filter(fullPerson -> fullPerson.getBday().equals(partialPerson.getBday()) ||
//                    fullPerson.getName().equals(partialPerson.getName())).forEach(fullPerson -> {
//                partialPerson.getParents().forEach(fullPerson::addParent);
//                partialPerson.getChildren().forEach(fullPerson::addChild);
//                partialPerson.changeName(fullPerson.getName());
//                partialPerson.changeBirthday(fullPerson.getBday());
//            });
//        });
//        fullDataPeople.forEach(person -> {
//            if (person.getName().equals(personWanted.getName()) ||
//                    person.getBday().equals(personWanted.getBday())) {
//                System.out.println(person);
//            }
//        });
//    }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> fulDataPeople = new ArrayList<>();
        List<Person> halfDataPeople = new ArrayList<>();

        String searchedPerson = reader.readLine();
        String searchedName = "";
        String searchedBday = "";
        if(searchedPerson.contains("/")){
            searchedBday = searchedPerson;
        }else{
            searchedName = searchedPerson;
        }

        Person wantedPerson = new Person(searchedName, searchedBday);

        String line = reader.readLine();

        while(!"End".equals(line)){
           String[] lineArgs = line.split(" - ");

            switch (lineArgs.length){
                case 1:
                    String[] personArgs = line.split(" ");
                    String name = personArgs[0] + " " + personArgs[1];
                    String birthDay = personArgs[2];

                    Person person = new Person(name, birthDay);
                    fulDataPeople.add(person);
                    break;
                case 2:
                    String parentNameOrBday = lineArgs[0];
                    String childNameOrBday = lineArgs[1];

                    Person parent = null;
                    if(parentNameOrBday.contains("/")){
                        parent = new Person("", parentNameOrBday);
                    }else{
                        parent = new Person(parentNameOrBday, "");
                    }

                    Person child = null;

                    if(childNameOrBday.contains("/")){
                        child = new Person("", childNameOrBday);
                    }else{
                        child = new Person(childNameOrBday, "");
                    }

                    parent.addChild(child);
                    child.addParent(parent);
                    halfDataPeople.add(parent);
                    halfDataPeople.add(child);
                    break;
            }

            line = reader.readLine();
        }

        halfDataPeople.forEach(halfPerson -> {
            fulDataPeople.stream().filter(person -> person.getName().equals(halfPerson.getName()) || person.getBday().equals(halfPerson.getBday()))
                    .forEach(fullPerson -> {
                if (fullPerson.getName().equals(halfPerson.getName()) || fullPerson.getBday().equals(halfPerson.getBday())) {
                    halfPerson.getParents().forEach(fullPerson::addParent);
                    halfPerson.getChildren().forEach(fullPerson::addChild);
                    halfPerson.changeName(fullPerson.getName());
                    halfPerson.changeBirthday(fullPerson.getBday());
                }
            });
        });

        fulDataPeople.forEach(person -> {
            if(person.getName().equals(wantedPerson.getName()) || person.getBday().equals(wantedPerson.getBday())){
                System.out.println(person);
            }
        });
    }
}
