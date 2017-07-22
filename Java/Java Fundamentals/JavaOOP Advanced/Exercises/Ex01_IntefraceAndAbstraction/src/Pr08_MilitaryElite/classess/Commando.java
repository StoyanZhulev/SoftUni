package Pr08_MilitaryElite.classess;

import Pr08_MilitaryElite.interfaces.ICommando;

import java.util.*;

public class Commando extends SpecialisedSoldier implements ICommando{
    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName,double salary, String corps) {
        super(id, firstName, lastName,salary, corps);
        this.missions = new ArrayList<>();
    }


    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        String sup = super.toString();
        StringBuilder sb = new StringBuilder(sup);
        sb.append("\n");
        sb.append("Missions:\n");
        for (Mission m : this.getMissions()) {
            //if(m.getState().equals("inProgress")){
                sb.append("  ").append(m.toString());
            //}
        }

        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }
}
