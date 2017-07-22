package Pr03_BarracksWars.core.commands;

import Pr03_BarracksWars.annotations.Inject;
import Pr03_BarracksWars.contracts.Repository;
import Pr03_BarracksWars.contracts.Unit;
import Pr03_BarracksWars.contracts.UnitFactory;

public class AddCommand extends Command{
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
