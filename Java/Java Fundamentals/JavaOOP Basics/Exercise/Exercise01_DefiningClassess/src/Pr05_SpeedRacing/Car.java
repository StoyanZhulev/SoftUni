package Pr05_SpeedRacing;

public class Car {
    private String carModel;
    private double carfuelAmount;
    private double fuelCostPerKm;
    private double distanceTravelled;

    public Car(String carModel, double carfuelAmount, double fuelCostPerKm){
        this.carModel = carModel;
        this.carfuelAmount = carfuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTravelled = 0;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getCarfuelAmount() {
        return carfuelAmount;
    }

    private double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    private void setCarfuelAmount(double carfuelAmount) {
        this.carfuelAmount = carfuelAmount;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void carTravell(double distance){
        if(this.getCarfuelAmount() < distance * this.getFuelCostPerKm()){
            throw new IllegalArgumentException("Insufficient fuel for the drive");
        }
        this.carfuelAmount -= distance * this.fuelCostPerKm;
        this.distanceTravelled += distance;
    }
}
