package Pr02_ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height){
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
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

    private void setLength(double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");

        }
        this.height = height;
    }
}
