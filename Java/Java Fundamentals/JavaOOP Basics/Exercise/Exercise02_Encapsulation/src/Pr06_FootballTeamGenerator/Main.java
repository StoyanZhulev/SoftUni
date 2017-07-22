package Pr06_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Team> teams = new HashMap<>();


        String line = reader.readLine();
        while (!"END".equals(line)){
            String[] lineArgs = line.split(";");
            switch (lineArgs[0]){
                case "Team":
                    createTeam(lineArgs, teams);
                    break;
                case "Add":
                    addPLayerToTeam(lineArgs, teams);
                    break;
                case "Remove":
                    removePlayerFromTeam(lineArgs, teams);
                    break;
                case "Rating":
                    showRating(lineArgs, teams);
            }

            line = reader.readLine();
        }
    }

    private static void showRating(String[] lineArgs, HashMap<String, Team> teams) {
        String teamName = lineArgs[1];
        if(!teams.containsKey(teamName)){
            System.out.printf("Team %s does not exist.%n", teamName);
        }else{
            System.out.printf("%s - %.0f%n", teamName, teams.get(teamName).getRating());
        }
    }

    private static void removePlayerFromTeam(String[] lineArgs, HashMap<String, Team> teams) {
        try{
            String teamName = lineArgs[1];

            String playerName = lineArgs[2];
            if(!teams.containsKey(teamName)){
                System.out.printf("Team %s does not exist.%n", teamName);
            }else{
                teams.get(teamName).removePlayer((playerName));
            }
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private static void addPLayerToTeam(String[] lineArgs, HashMap<String, Team> teams) {
        try{
            String teamName = lineArgs[1];

            if(!teams.containsKey(teamName)){
                System.out.printf("Team %s does not exist.%n", teamName);
            }else{
                Player player = new Player((lineArgs[2]), Double.parseDouble(lineArgs[3]), Double.parseDouble(lineArgs[4]), Double.parseDouble(lineArgs[5]), Double.parseDouble(lineArgs[6]), Double.parseDouble(lineArgs[7]));
                teams.get(teamName).addPlayer(player);
            }
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }

    private static void createTeam(String[] lineArgs, HashMap<String, Team> teams) {
        try{
                Team team = new Team(lineArgs[1]);
                teams.put(team.getName(), team);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }
}
