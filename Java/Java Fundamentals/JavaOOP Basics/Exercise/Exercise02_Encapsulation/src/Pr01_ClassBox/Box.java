package Pr01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getSurfaceVolume(){
        return 2 * this.width * this.length + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double getVolume(){
        return this.height * this.width * this.length;
    }

    public double getLateralSurfaceArea(){
        return 2 * this.width * this.height + 2 * this.height * this.length;
    }
}
