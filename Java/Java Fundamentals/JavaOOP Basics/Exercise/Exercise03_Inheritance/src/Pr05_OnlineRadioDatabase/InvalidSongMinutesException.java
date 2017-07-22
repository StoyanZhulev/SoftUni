package Pr05_OnlineRadioDatabase;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(){
        super("Song minutes should be between 0 and 14.");
    }

    public String getMessage(){
        return super.message;
    }
}
