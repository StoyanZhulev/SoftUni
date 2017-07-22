package Pr09_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name){
        this.name = name;
        this.company = new Company("", "", "");
        this.car = new Car("", "");
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void updateProperty(Object property){
        String propertyType = property.getClass().getSimpleName();
        switch (propertyType){
            case "Company":
                this.company = (Company)property;
                break;
            case "Car":
                this.car = (Car) property;
                break;
            default:
                break;
        }
    }

    public void addProperty(Object property){
        String propertyType = property.getClass().getSimpleName();
        switch (propertyType){
            case "Parent":
                this.parents.add((Parent) property);
                break;
            case "Child":
                this.children.add((Child) property);
                break;
            case "Pokemon":
                this.pokemons.add((Pokemon) property);
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator())
                .append(this.company.toString())
                .append(this.car.toString())
                .append("Pokemon:\n");
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon.toString());
        }
        sb.append("Parents:\n");
        for (Parent parent : parents) {
            sb.append(parent.toString());
        }
        sb.append("Children:\n");
        for (Child child : children) {
            sb.append(child.toString());
        }

        return sb.toString();
    }
}
