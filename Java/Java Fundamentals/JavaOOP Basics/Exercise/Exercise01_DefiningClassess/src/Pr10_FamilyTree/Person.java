package Pr10_FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String bday;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String bday){
        this.name = name;
        this.bday = bday;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void changeName(String name) {
        this.setName(name);
    }

    public void changeBirthday(String birthday) {
        this.setBday(birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getName() {
        return name;
    }

    public String getBday() {
        return bday;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child){
        this.getChildren().add(child);
    }

    public void addParent(Person parent){
        this.getParents().add(parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" ").append(this.getBday()).append("\n")
                .append("Parents:\n");
        for (Person parent : this.parents) {
            sb.append(parent.getName()).append(" ").append(parent.getBday()).append("\n");
        }
        sb.append("Children:\n");
        for (Person child : this.children) {
            sb.append(child.getName()).append(" ").append(child.getBday()).append("\n");

        }
        return sb.toString();
    }
}
