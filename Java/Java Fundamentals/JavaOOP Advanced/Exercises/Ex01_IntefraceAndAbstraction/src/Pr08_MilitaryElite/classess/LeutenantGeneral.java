package Pr08_MilitaryElite.classess;

import Pr08_MilitaryElite.interfaces.ILeutenantGeneral;

import java.util.*;

public class LeutenantGeneral extends Private implements ILeutenantGeneral{
    private List<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public List<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivates(Private pr) {
        this.privates.add(pr);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String sup = super.toString();
        sb.append(sup);
        sb.append("\n");
        sb.append("Privates:").append("\n");
        for (Private p : privates) {
            sb.append("  ").append(p.toString()).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
