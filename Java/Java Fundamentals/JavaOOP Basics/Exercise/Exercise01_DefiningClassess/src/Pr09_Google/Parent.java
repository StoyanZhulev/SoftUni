package Pr09_Google;

public class Parent {
    private String name;
    private String birthDay;

    public Parent(String name, String birthday){
        this.name = name;
        this.birthDay = birthday;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.birthDay).append(System.lineSeparator());

        return sb.toString();
    }
}
