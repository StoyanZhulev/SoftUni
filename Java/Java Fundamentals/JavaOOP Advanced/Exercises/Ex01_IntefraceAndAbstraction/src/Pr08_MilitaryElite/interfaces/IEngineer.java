package Pr08_MilitaryElite.interfaces;

import Pr08_MilitaryElite.classess.Repair;

import java.util.List;

public interface IEngineer {
    List<Repair> getRepairs();

    void addRepair(Repair repair);
}
