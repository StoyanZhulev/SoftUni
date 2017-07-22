package app.waste_disposal.commands;

import app.waste_disposal.StatusContainer;
import app.waste_disposal.annotations.InjectField;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factories.StrategyFactory;
import app.waste_disposal.factories.WasteFactory;
import app.waste_disposal.io.Writer;
import app.waste_disposal.models.ManagementRequirement;

public class ProcessGarbageCommand implements Executable{
    private static final String PROCESSING_DENIED = "Processing Denied!";

    @InjectField
    private GarbageProcessor garbageProcessor;
    @InjectField
    private WasteFactory wasteFactory;
    @InjectField
    private StrategyFactory strategyFactory;
    @InjectField
    private StatusContainer statusContainer;
    @InjectField
    private Writer writer;
    @InjectField
    private ManagementRequirement managementRequirement;




    @Override
    public void execute(String[] lineArgs) {
        Waste waste = this.wasteFactory.makeGarbage(lineArgs);
        GarbageDisposalStrategy strategy = this.strategyFactory.createStrategy(lineArgs[4]);


        this.garbageProcessor.getStrategyHolder().addStrategy(waste.getClass().getDeclaredAnnotations()[0].annotationType(), strategy);
        ProcessingData processingData = this.garbageProcessor.processWaste(waste);
        if(lineArgs[4].equals(this.managementRequirement.getDeniedType())){
            if(this.statusContainer.getEnergy() < this.managementRequirement.getRequiredEnergy() || this.statusContainer.getBalance() < this.managementRequirement.getRequiredCapital()){
                this.writer.writeLine(PROCESSING_DENIED);
            }else{
                this.statusContainer.processData(processingData);
                this.writer.writeLine(waste.toString());
            }
        }else{
            this.statusContainer.processData(processingData);
            this.writer.writeLine(waste.toString());

        }

    }
}
