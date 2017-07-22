package Pr02_VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{

    private double currentConsumption;

    public Bus(double fuelCapacity, double consumption, double tankCapacity) {
        super(fuelCapacity, consumption, tankCapacity);
    }

    public double getCurrentConsumption() {
        return currentConsumption;
    }

    public void setCurrentConsumption(String busOccupation) {
        switch (busOccupation.toLowerCase()){
            case "driveempty":
                this.currentConsumption = this.getConsumptionPerKm();
                break;
            case "drive":
                this.currentConsumption = this.getConsumptionPerKm() + 1.4;
                break;
        }
    }

    @Override
    protected void refuelCapacity(double fuelCapacity) {
        if (fuelCapacity + this.getFuelCapacity() > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelCapacity(this.getFuelCapacity() + fuelCapacity);
    }

    @Override
    protected void driveDistance(double distance) {
        if (distance * this.getCurrentConsumption() > this.getFuelCapacity()) {
            throw new IllegalArgumentException("Bus needs refueling");
        }

        if((this.getFuelCapacity() - distance * this.getCurrentConsumption()) < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelCapacity(this.getFuelCapacity() - distance * this.getCurrentConsumption());
        DecimalFormat format = new DecimalFormat("#.#########################");
        System.out.printf("Bus travelled %s km%n",  format.format(distance));
    }
}
