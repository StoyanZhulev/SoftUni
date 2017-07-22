package Pr08_MilitaryElite.classess;

import Pr08_MilitaryElite.interfaces.ISpy;

public class Spy extends Soldier implements ISpy{
    private int codeNumber;

    public Spy(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return "Name: "
                +this.getFirstName()
                +" "
                +this.getLastName()
                +" Id: "
                +this.getId()
                + "\n"
                +"Code Number: "
                +this.codeNumber;
    }
}
