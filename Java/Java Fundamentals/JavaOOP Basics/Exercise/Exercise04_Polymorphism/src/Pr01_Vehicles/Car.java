package Pr01_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelCapacity, double consumption){
        super(fuelCapacity, consumption);
        this.setConsumptionPerKm(consumption);
    }

    @Override
    protected void setConsumptionPerKm(double consumptionPerKm) {
        super.setConsumptionPerKm(consumptionPerKm + 0.9);
    }

    @Override
    protected void refuelCapacity(double fuel) {
        this.setFuelCapacity(this.getFuelCapacity() + fuel);
    }

    @Override
    protected void driveDistance(double distance) {
        if(distance * this.getConsumptionPerKm() <= this.getFuelCapacity()){
            this.setFuelCapacity(this.getFuelCapacity() - distance * this.getConsumptionPerKm());
            DecimalFormat format = new DecimalFormat("#.#########################");
            System.out.printf("Car travelled %s km%n", format.format(distance));
        }else{
            System.out.println("Car needs refueling");
        }

    }
}
