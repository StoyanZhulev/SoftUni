package Pr05_ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person p) {
        if(this.getName().equals(p.getName())){
            if(this.getAge() == p.getAge()){
                return this.getTown().compareTo(p.getTown());
            }else{
                return this.getAge() - p.getAge();
            }
        }else{
            return this.getName().compareTo(p.getName());
        }
    }
}
