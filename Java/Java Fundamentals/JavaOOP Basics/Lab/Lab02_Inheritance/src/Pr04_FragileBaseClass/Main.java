package Pr04_FragileBaseClass;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator();

        predator.feedAll(new Food[]{new Food(), new Food()});
        predator.feed(new Food());
    }


}
