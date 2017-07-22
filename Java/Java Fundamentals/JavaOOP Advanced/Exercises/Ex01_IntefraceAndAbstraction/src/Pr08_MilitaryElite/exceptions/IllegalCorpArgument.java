package Pr08_MilitaryElite.exceptions;

public class IllegalCorpArgument extends IllegalArgumentException {
    private static final String MESSAGE = "Invalid Corp";

    public IllegalCorpArgument(){
        super(MESSAGE);
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
