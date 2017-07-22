import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Pr04_Highscores {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Long> playersTotalScores = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<String>> playerDuels = new LinkedHashMap<>();


        String input = reader.readLine();

        while (!"osu!".equals(input)){
            String[] inputArgs = input.split("<->");
            String[] player1Args = inputArgs[0].split(" ");
            Long player1Score = Long.parseLong(player1Args[0]);
            String player1Name = player1Args[1];
            String[] player2Args = inputArgs[1].split(" ");
            Long player2Score = Long.parseLong(player2Args[1]);
            String player2Name = player2Args[0];
            long player1diff = 0;
            long player2diff = 0;
            if(player1Score > player2Score){
                player1diff = player1Score - player2Score;
                player2diff = player2Score - player1Score;
                player1Score += player1Score - player2Score;
                player2Score -= player1Score - player2Score;

            }else if(player2Score > player1Score){
                player1diff = player1Score - player2Score;
                player2diff = player2Score - player1Score;
                player2Score += player2Score - player1Score;
                player1Score -= player2Score - player1Score;

            }

            if(!playerDuels.containsKey(player1Name)){
                playerDuels.put(player1Name, new ArrayList<>());
                playerDuels.get(player1Name).add(player2Name + " <-> " + player1diff);
                playersTotalScores.put(player1Name, player1diff);
            }else{
                playerDuels.get(player1Name).add(player2Name + " <-> "+ player1diff);
                playersTotalScores.put(player1Name, playersTotalScores.get(player1Name) + player1diff);
            }

            if(!playerDuels.containsKey(player2Name)){
                playerDuels.put(player2Name, new ArrayList<>());
                playerDuels.get(player2Name).add(player1Name + " <-> " +player2diff);
                playersTotalScores.put(player2Name, player2diff);

            }else{
                playerDuels.get(player2Name).add(player1Name+ " <-> " + player2diff);
                playersTotalScores.put(player2Name, playersTotalScores.get(player2Name) + player2diff);

            }

            input = reader.readLine();
        }

        playerDuels.entrySet().stream()
                .sorted((v1, v2) -> playersTotalScores.get(v2.getKey()).compareTo(playersTotalScores.get(v1.getKey())))
                .forEach(player -> {
                    System.out.printf("%s - (%d)%n", player.getKey(), playersTotalScores.get(player.getKey()));
                    ArrayList<String> currList = player.getValue();
                    for (String s : currList) {
                        System.out.println("*   " + s);
                    }

                });
    }
}
