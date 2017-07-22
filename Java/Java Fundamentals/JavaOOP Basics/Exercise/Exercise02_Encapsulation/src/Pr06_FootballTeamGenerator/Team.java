package Pr06_FootballTeamGenerator;

import java.util.ArrayList;

public class Team {
    private String name;
    private double rating;
    private ArrayList<Player> players;

    public Team(String name){
        this.setName(name);
        this.players = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {
        double teamRating = 0.0;

        for (Player player : this.players) {
            teamRating += Math.round(player.getOverallSkill());

        }

        if(!this.players.isEmpty()){

            teamRating = teamRating / this.players.size();
        }

        return teamRating;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(String playerName){
        Player playerToBeRemoved = null;
        for (Player player : this.players) {
            if(player.getName().equals(playerName)){
                playerToBeRemoved = player;
                break;
            }
        }
        if(playerToBeRemoved == null){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",playerName,  this.name));
        }
        this.players.remove(playerToBeRemoved);
    }
}
