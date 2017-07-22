package Pr05_OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        PlayList playList = new PlayList();
        for (int i = 0; i < num; i++) {
            String[] songArgs = reader.readLine().split("[;:]");
            String artistName = songArgs[0];
            String songName = songArgs[1];
            int minutes = 0;
            int seconds = 0;
            try{
                 minutes = Integer.parseInt(songArgs[2]);
                 seconds = Integer.parseInt(songArgs[3]);

            }catch (NumberFormatException nfe){
                System.out.println("Invalid song length.");
                continue;
            }


            try{

                Song song = new Song(artistName, songName, minutes, seconds);
                playList.addSong(song);
            }catch (InvalidSongException ise){
                System.out.println(ise.getMessage());
            }

        }

        System.out.println("Songs added: " + playList.getSongs().size());
        System.out.println("Playlist length: " + playList.getLength());
    }
}
