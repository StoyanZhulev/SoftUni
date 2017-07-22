package app.waste_disposal;

import app.waste_disposal.contracts.ProcessingData;

public class ProcessingDataImpl implements ProcessingData {
    private static final double INITIAL_BALANCE = 0.0;
    private double energyBalance;
    private double capitalBalance;

    public ProcessingDataImpl() {
        this.energyBalance = INITIAL_BALANCE;
        this.capitalBalance = INITIAL_BALANCE;
    }
    public ProcessingDataImpl(double energy, double balance) {
        this.energyBalance = energy;
        this.capitalBalance = balance;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }
}
