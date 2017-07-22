package Pr08_MilitaryElite.classess;

import Pr08_MilitaryElite.interfaces.IRepair;

public class Repair implements IRepair{
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return "Part Name: "
                + this.getPartName()
                +" Hours Worked: "
                +this.getHoursWorked()
                +"\n";
    }
}
