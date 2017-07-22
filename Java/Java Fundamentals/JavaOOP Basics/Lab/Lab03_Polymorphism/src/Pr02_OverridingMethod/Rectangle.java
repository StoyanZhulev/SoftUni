package Pr02_OverridingMethod;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double sideA){
        this.sideA = sideA;
    }

    protected double getSideA(){
        return this.sideA;
    }

    public double area(){
        return this.sideA * this.sideB;
    }
}
