package Pr08_MilitaryElite.interfaces;

import Pr08_MilitaryElite.classess.Private;

import java.util.List;

public interface ILeutenantGeneral {

    List<Private> getPrivates();

    void addPrivates(Private pr);
}
