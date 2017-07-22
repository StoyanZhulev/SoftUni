package app.waste_disposal.models.strategies;

import app.waste_disposal.ProcessingDataImpl;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;


public class BurnableStrategy extends ConcreteGarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalGarbageVolume = garbage.getWeight() * garbage.getVolumePerKg();
        double energyEarned = totalGarbageVolume;
        double energyUsed = totalGarbageVolume * 0.20;
        double capitalEarned = 0.0;
        double capitalUsed = 0.0;

        double totalEnergy = energyEarned - energyUsed;
        double totalCapital = capitalEarned - capitalUsed;

        return new ProcessingDataImpl(totalEnergy, totalCapital);
    }
}
