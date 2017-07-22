package Pr07_EqualityLogic;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        int result = 17; // It's good to be a prime number

        result = 31 * result + this.getAge();
        result = 31 * result + this.getName().hashCode();

        return result;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(!(obj instanceof Person)){
            return false;
        }

        Person person2 = (Person) obj;
        if(!this.getName().equals(person2.getName())){
            return false;
        }
        if(this.getAge() != person2.getAge()){
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Person person) {
        if (this.getName().compareTo(person.getName()) == 0) {
            return this.getAge() - person.getAge();
        }
        return this.getName().compareTo(person.getName());
    }
}
