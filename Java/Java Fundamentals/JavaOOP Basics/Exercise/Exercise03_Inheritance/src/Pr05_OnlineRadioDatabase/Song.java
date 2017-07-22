package Pr05_OnlineRadioDatabase;

public class Song {
    private String artist;
    private String name;
    private int minutes;
    private int seconds;
    private int timeInSeconds;

    public Song(String artist, String name, int minutes, int seconds) {
        this.setArtist(artist);
        this.setName(name);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
        this.setTimeInSeconds(this.getMinutes(), this.getSeconds());
    }

    private void setArtist(String artist) {
        if(artist == null || artist.trim().length() < 3 || artist.trim().length() > 20){
            throw new InvaliArtistNameException();
        }
        this.artist = artist;
    }

    private void setName(String name) {
        if(name == null || name.trim().length() < 3 || name.trim().length() > 30){
            throw new InvalidSongNameExcption();
        }
        this.name = name;
    }

    public int getMinutes() {
        return minutes;
    }

    private void setMinutes(int minutes) {
        if(minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException();
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private void setSeconds(int seconds) {
        if(seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    private void setTimeInSeconds(int minutes, int seconds) {
        this.timeInSeconds = minutes * 60 + seconds;
    }
}
