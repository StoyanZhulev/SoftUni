package Pr05_OnlineRadioDatabase;

public class InvaliArtistNameException extends InvalidSongException{

    public InvaliArtistNameException(){
        super("Artist name should be between 3 and 20 symbols.");

    }

    public String getMessage(){
        return super.message;
    }
}
