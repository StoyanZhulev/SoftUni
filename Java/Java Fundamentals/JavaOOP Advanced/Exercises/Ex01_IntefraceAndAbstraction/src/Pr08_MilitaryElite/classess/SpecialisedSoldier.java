package Pr08_MilitaryElite.classess;

import Pr08_MilitaryElite.exceptions.IllegalCorpArgument;
import Pr08_MilitaryElite.interfaces.ISpecialisedSoldier;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private static final String AIRFORCE_CORP = "Airforces";
    private static final String MARINES_CORP = "Marines";

    private String corps;


    protected SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public void setCorps(String corps) {
        if(!corps.equals(AIRFORCE_CORP) && !corps.equals(MARINES_CORP)){
            throw new IllegalCorpArgument();
        }
       this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Corps: " + this.getCorps();
    }
}
