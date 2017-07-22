package Pr03_BarracksWars.core.commands;

import Pr03_BarracksWars.annotations.Inject;
import Pr03_BarracksWars.contracts.Repository;

public class ReportCommand extends Command{
    @Inject
    private Repository repository;
    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        return this.repository.getStatistics();
    }
}
