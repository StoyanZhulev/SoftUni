package Pr05_OnlineRadioDatabase;

public class InvalidSongNameExcption extends InvalidSongException {

    public InvalidSongNameExcption(){
        super("Song name should be between 3 and 30 symbols.");

    }

    public String getMessage(){
        return super.message;
    }
}
