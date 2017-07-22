package app.waste_disposal;

import app.waste_disposal.contracts.ProcessingData;

public class StatusContainer {

    private static final double INITIAL_VALUE = 0.0;
    private static final String ENERGY_AND_CAPITAL = "Energy: %.2f Capital: %.2f";
    private double energy;
    private double balance;

    public StatusContainer() {
        this.energy = INITIAL_VALUE;
        this.balance = INITIAL_VALUE;
    }

    public double getEnergy() {
        return this.energy;
    }

    public double getBalance() {
        return this.balance;
    }

    public void updateEnergy(double energy){
        this.energy += energy;
    }

    public void updateBalance(double capital){
        this.balance += capital;
    }

    public void processData(ProcessingData processingData){
        this.energy += processingData.getEnergyBalance();
        this.balance += processingData.getCapitalBalance();
    }

    @Override
    public String toString() {
        return String.format(ENERGY_AND_CAPITAL, this.energy, this.balance);
    }
}
