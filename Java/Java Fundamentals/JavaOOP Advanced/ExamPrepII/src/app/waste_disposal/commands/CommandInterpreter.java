package app.waste_disposal.commands;

public interface CommandInterpreter {
    Executable interpretCommand(String cmdType);
}
