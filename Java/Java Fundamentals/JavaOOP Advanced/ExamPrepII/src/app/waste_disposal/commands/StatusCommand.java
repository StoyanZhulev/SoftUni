package app.waste_disposal.commands;

import app.waste_disposal.StatusContainer;
import app.waste_disposal.annotations.InjectField;
import app.waste_disposal.io.Writer;

public class StatusCommand implements Executable {
    @InjectField
    private StatusContainer statusContainer;
    @InjectField
    private Writer writer;
    @Override
    public void execute(String[] lineArgs) {
        this.writer.writeLine(this.statusContainer.toString());
    }
}
