package Pr08_MilitaryElite.classess;

import Pr08_MilitaryElite.interfaces.IEngineer;

import java.util.*;

public class Engineer extends SpecialisedSoldier implements IEngineer{
    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName,double salary, String corps) {
        super(id, firstName, lastName,salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public List<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        String sup = super.toString();
        StringBuilder sb = new StringBuilder(sup);
        sb.append("\n");
        sb.append("Repairs:\n");
        for (Repair r : repairs) {
            sb.append("  ").append(r.toString());
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
