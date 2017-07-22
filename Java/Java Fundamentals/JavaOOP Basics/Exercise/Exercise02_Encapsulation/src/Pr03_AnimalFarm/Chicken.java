package Pr03_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age){
        this.setName(name);
        this.setAge(age);
    }


    private void setName(String name){
        if(name.trim().length() <= 0){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age){
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public void printProducedEggs(){

        if(age < 6){
            System.out.printf("Chicken %s (age %d) can produce 2 eggs per day.%n", this.name, this.age);
        }else if(age >= 6 && age <= 13){
            System.out.printf("Chicken %s (age %d) can produce 1 eggs per day.%n", this.name, this.age);
        }else{
            System.out.printf("Chicken %s (age %d) can produce 0.75 eggs per day.%n", this.name, this.age);
        }
    }
}
