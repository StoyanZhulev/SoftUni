package app.waste_disposal.commands;

import app.waste_disposal.annotations.InjectField;
import app.waste_disposal.io.Writer;
import app.waste_disposal.models.ManagementRequirement;

public class ChangeManagementRequirementCommand implements Executable {
    private ManagementRequirement managementRequirement;
    @InjectField
    Writer writer;

    public ChangeManagementRequirementCommand() {
    }

    @Override
    public void execute(String[] lineArgs) {
        this.managementRequirement = new ManagementRequirement(Double.parseDouble(lineArgs[1]), Double.parseDouble(lineArgs[2]), lineArgs[3]);
        this.writer.writeLine(this.managementRequirement.toString());
    }
}
