package Pr09_Google;

public class Child {
    private String name;
    private String birthday;

    public Child(String name, String birthday){
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.birthday).append(System.lineSeparator());

        return sb.toString();
    }
}
