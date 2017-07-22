package Pr02_CreatingConstructors;

public class Person {
    public String name;
    public int age;

    public Person(){
        this.name = "No name";
        this.age = 1;
    }

    public Person(int age){
        this.name = "No name";
        this.age = age;
    }

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }


}
