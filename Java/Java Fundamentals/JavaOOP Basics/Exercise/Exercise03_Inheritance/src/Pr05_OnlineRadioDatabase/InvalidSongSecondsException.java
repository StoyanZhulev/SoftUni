package Pr05_OnlineRadioDatabase;

public class InvalidSongSecondsException extends InvalidSongLengthException{


    public InvalidSongSecondsException(){
        super("Song seconds should be between 0 and 59.");
    }

    public String getMessage(){
        return super.message;
    }
}
