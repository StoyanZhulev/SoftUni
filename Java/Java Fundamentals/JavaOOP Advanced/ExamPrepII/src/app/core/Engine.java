package app.core;

import app.waste_disposal.StatusContainer;
import app.waste_disposal.annotations.InjectField;
import app.waste_disposal.commands.ChangeManagementRequirementCommand;
import app.waste_disposal.commands.CommandInterpreter;
import app.waste_disposal.commands.Executable;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.factories.StrategyFactory;
import app.waste_disposal.factories.WasteFactory;
import app.waste_disposal.io.Reader;
import app.waste_disposal.io.Writer;
import app.waste_disposal.models.ManagementRequirement;

import java.io.IOException;
import java.lang.reflect.Field;

public class Engine implements Runnable {
    private static final String TIME_TO_RECYCLE = "TimeToRecycle";

    private ManagementRequirement managementRequirement;
    private GarbageProcessor garbageProcessor;
    private WasteFactory wasteFactory;
    private StrategyFactory strategyFactory;
    private StatusContainer statusContainer;
    private Reader reader;
    private Writer writer;
    private CommandInterpreter cmdInterpreter;

    public Engine(GarbageProcessor garbageProcessor, WasteFactory wasteFactory, StrategyFactory strategyFactory, StatusContainer statusContainer, Reader reader, Writer writer, CommandInterpreter cmdInterpreter, ManagementRequirement managementRequirement) {
        this.garbageProcessor = garbageProcessor;
        this.wasteFactory = wasteFactory;
        this.strategyFactory = strategyFactory;
        this.statusContainer = statusContainer;
        this.reader = reader;
        this.writer = writer;
        this.cmdInterpreter = cmdInterpreter;
        this.managementRequirement = managementRequirement;
    }

    @Override
    public void run() {
        try {
            String line = reader.readLine();
            while (!TIME_TO_RECYCLE.equals(line)) {
                String[] lineArgs = line.split("[\\s\\|]+");
                Executable executableCommand = this.cmdInterpreter.interpretCommand(lineArgs[0]);
                this.injectDependancies(executableCommand);

                executableCommand.execute(lineArgs);
                if (executableCommand.getClass().equals(ChangeManagementRequirementCommand.class)) {
                    Class managementClass = ChangeManagementRequirementCommand.class;
                    Field[] managementFields = managementClass.getDeclaredFields();
                    for (Field managementField : managementFields) {
                        managementField.setAccessible(true);
                        for (Field thisField : this.getClass().getDeclaredFields()) {
                            if (managementField.getType().equals(thisField.getType())) {
                                thisField.setAccessible(true);
                                thisField.set(this, managementField.get(executableCommand));
                            }
                        }
                    }
                }

                line = reader.readLine();
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void injectDependancies(Executable executableCommand) {

        Class<?> cmdClass = executableCommand.getClass();
        Field[] fields = cmdClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectField.class)) {
                field.setAccessible(true);

                Field[] engineFields = this.getClass().getDeclaredFields();
                for (Field engineField : engineFields) {
                    if (!field.getType().equals(engineField.getType())) {
                        continue;
                    }
                    engineField.setAccessible(true);
                    try {
                        field.set(executableCommand, engineField.get(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
