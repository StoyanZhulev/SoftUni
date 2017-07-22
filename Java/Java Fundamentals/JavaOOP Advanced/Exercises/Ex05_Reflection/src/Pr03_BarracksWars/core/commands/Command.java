package Pr03_BarracksWars.core.commands;

import Pr03_BarracksWars.contracts.Executable;

public abstract class Command implements Executable{
    private String[] data;


    Command(String[] data) {
        this.data = data;
    }

    String[] getData() {
        return data;
    }

}
