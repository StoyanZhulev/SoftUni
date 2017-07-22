package Pr01_ShapesDrawing;

public class Circle implements Drawable{
    private int radius;
    private int centerX;
    private int centerY;

    public Circle(int radius, int centerX, int centerY) {
        this.setRadius(radius);
        this.setCenterX(centerX);
        this.setCenterY(centerY);
    }

    public int getRadius() {
        return this.radius;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX() {
        return this.centerX;
    }

    private void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return this.centerY;
    }

    private void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    @Override
    public void draw() {
    }
}
