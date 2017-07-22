package Pr03_Shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
        this.calculateArea();
        this.calculatePerimeter();
    }


    public final double getRadius() {
        return radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(Math.PI * this.radius * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.radius * this.radius * Math.PI);
    }
}
