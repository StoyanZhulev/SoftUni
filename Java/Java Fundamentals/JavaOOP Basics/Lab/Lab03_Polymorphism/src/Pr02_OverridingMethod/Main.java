package Pr02_OverridingMethod;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5.0, 3.0);
        Square square = new Square(4.0);

        Rectangle rectange = new Square(8.0);

        System.out.println(square.area());
    }
}
