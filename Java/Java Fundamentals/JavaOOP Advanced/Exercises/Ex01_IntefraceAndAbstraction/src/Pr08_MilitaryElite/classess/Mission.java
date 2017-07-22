package Pr08_MilitaryElite.classess;

import Pr08_MilitaryElite.exceptions.IllegalMissionArgumen;
import Pr08_MilitaryElite.interfaces.IMission;

public class Mission implements IMission{
    private static final String IN_PROGRESS = "inProgress";
    private static final String FINISHED = "Finished";

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    private void setState(String state) {
        if(!state.equals(FINISHED) && !state.equals(IN_PROGRESS)){
            throw new IllegalMissionArgumen();
        }
      this.state = state;
    }

    @Override
    public void completeMission() {
        this.setState(FINISHED);
    }

    @Override
    public String toString() {
        return "Code Name: "
                +this.getCodeName()
                +" State: "
                +this.getState()
                +"\n";
    }
}
