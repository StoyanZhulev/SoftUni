package Pr05_OnlineRadioDatabase;

public class InvalidSongException extends IllegalArgumentException{
    protected String message;


    public InvalidSongException(String message){
        super();
        this.setMessage(message);
    }

    private void setMessage(String message){
        this.message = message;
    }
}
