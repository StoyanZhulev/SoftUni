package Pr01_Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelCapacity, double consumption){
        super(fuelCapacity, consumption);
        this.setConsumptionPerKm(consumption);
    }

    @Override
    protected void setConsumptionPerKm(double consumptionPerKm) {
        super.setConsumptionPerKm(consumptionPerKm + 1.6);
    }

    @Override
    protected void refuelCapacity(double fuel) {
        this.setFuelCapacity(this.getFuelCapacity() + fuel * 0.95);
    }

    @Override
    protected void driveDistance(double distance) {
        if(distance * this.getConsumptionPerKm() <= this.getFuelCapacity()){
            this.setFuelCapacity(this.getFuelCapacity() - distance * this.getConsumptionPerKm());
            DecimalFormat format = new DecimalFormat("#.#########################");
            System.out.printf("Truck travelled %s km%n", format.format(distance));
        }else{
            System.out.println("Truck needs refueling");
        }

    }
}
