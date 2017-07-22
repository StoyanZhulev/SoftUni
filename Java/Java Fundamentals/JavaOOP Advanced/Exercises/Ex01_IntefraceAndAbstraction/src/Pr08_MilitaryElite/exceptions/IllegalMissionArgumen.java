package Pr08_MilitaryElite.exceptions;

public class IllegalMissionArgumen extends IllegalArgumentException {
    private static final String MESSAGE = "Invalid mission";

    public IllegalMissionArgumen(){
        super(MESSAGE);
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
