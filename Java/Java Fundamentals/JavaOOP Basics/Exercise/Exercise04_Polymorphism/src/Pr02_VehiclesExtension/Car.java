package Pr02_VehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelCapacity, double consumption, double tankCapacity) {
        super(fuelCapacity, consumption, tankCapacity);
        this.setConsumptionPerKm(consumption);
    }

    @Override
    protected void setConsumptionPerKm(double consumptionPerKm) {
        super.setConsumptionPerKm(consumptionPerKm + 0.9);
    }

    @Override
    protected void refuelCapacity(double fuel) {
        if (fuel + this.getFuelCapacity() > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelCapacity(this.getFuelCapacity() + fuel);
    }

    @Override
    protected void driveDistance(double distance) {
        if (distance * this.getConsumptionPerKm() > this.getFuelCapacity()) {
            throw new IllegalArgumentException("Car needs refueling");
        }

        if((this.getFuelCapacity() - distance * this.getConsumptionPerKm()) < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelCapacity(this.getFuelCapacity() - distance * this.getConsumptionPerKm());
        DecimalFormat format = new DecimalFormat("#.#########################");
        System.out.printf("Car travelled %s km",  format.format(distance));


    }
}
