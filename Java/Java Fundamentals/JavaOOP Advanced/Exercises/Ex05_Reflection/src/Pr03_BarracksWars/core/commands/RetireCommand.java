package Pr03_BarracksWars.core.commands;

import Pr03_BarracksWars.annotations.Inject;
import Pr03_BarracksWars.contracts.Repository;

public class RetireCommand extends Command{
    @Inject
    private Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
       return this.repository.removeUnit(this.getData()[1]);
    }
}
