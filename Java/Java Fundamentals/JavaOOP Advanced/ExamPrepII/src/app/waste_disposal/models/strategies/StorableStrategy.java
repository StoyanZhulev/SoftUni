package app.waste_disposal.models.strategies;

import app.waste_disposal.ProcessingDataImpl;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;


public class StorableStrategy extends ConcreteGarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalGarbageVolume = garbage.getWeight() * garbage.getVolumePerKg();
        double energyEarned = 0;
        double energyUsed = totalGarbageVolume * 0.13;
        double capitalEarned = 0.0;
        double capitalUsed = totalGarbageVolume * 0.65;

        double totalEnergy = energyEarned - energyUsed;
        double totalCapital = capitalEarned - capitalUsed;

        return new ProcessingDataImpl(totalEnergy, totalCapital);
    }
}
