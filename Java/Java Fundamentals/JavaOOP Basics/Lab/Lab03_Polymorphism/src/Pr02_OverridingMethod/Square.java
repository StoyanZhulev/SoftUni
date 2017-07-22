package Pr02_OverridingMethod;

public class Square extends Rectangle{
    public Square(double side){
        super(side);
    }


    public double perimeter(){
        return this.getSideA() * 4;
    }

    @Override
    public double area() {
        return super.getSideA() * this.getSideA();
    }
}
