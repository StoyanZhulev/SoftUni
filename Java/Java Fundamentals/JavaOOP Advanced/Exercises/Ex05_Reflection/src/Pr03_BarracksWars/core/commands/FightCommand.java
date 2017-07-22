package Pr03_BarracksWars.core.commands;

public class FightCommand extends Command{

    private static final String FIGHT = "fight";

    public FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        return FIGHT;
    }
}
