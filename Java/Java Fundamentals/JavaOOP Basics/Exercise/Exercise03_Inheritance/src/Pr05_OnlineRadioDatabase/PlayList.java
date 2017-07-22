package Pr05_OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayList {
    private List<Song> songs;
    private String length;

    public PlayList(){
        this.songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    public void addSong(Song song) {
        this.songs.add(song);
        System.out.println("Song added.");
    }

    public String getLength() {
        this.setLength();
        return length;
    }

    public void setLength() {

        int timeInSeconds = 0;

        for (Song song : songs) {
            timeInSeconds += song.getTimeInSeconds();
        }

        int hours = timeInSeconds / 3600;
        int minutes = (timeInSeconds % 3600) / 60;
        int seconds = timeInSeconds % 60;

        this.length = String.format("%sh %sm %ss", hours, minutes, seconds);
    }
}
