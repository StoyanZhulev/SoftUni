package Pr09_Google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type){
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.type).append(System.lineSeparator());

        return sb.toString();
    }
}
