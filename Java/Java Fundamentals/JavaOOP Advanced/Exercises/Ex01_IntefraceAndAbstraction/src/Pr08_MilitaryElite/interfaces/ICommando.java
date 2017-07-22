package Pr08_MilitaryElite.interfaces;

import Pr08_MilitaryElite.classess.Mission;

import java.util.List;

public interface ICommando {
    List<Mission> getMissions();

    void addMission(Mission mission);
}
