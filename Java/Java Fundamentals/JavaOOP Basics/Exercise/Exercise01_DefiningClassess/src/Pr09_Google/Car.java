package Pr09_Google;

public class Car {
    private String model;
    private String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        if(this.model.equals("")){
            return "Car: \n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Car:").append(System.lineSeparator());
        sb.append(this.model).append(" ").append(this.speed).append(System.lineSeparator());
        return sb.toString();
    }
}
