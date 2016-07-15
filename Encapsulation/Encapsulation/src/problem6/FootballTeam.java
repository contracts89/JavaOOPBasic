package problem6;

import java.util.ArrayList;

/**
 * Created by Radoslav on 14.7.2016 г..
 */
public class FootballTeam {
    private String name;
    private ArrayList<Player> players;
    private double stats;

    public FootballTeam(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
        this.setStats(0d);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name.equals("")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private ArrayList<Player> getPlayers() {
        return players;
    }

    private void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    private void setStats(double stats) {
        this.stats = stats;
    }

    public double getStats() {
        return stats;
    }

    public void addPlayers(Player player){
        this.players.add(player);
    }

    public void removePlayer(String playerName){
        int size = this.getPlayers().size();
        boolean playerIsInTeam = false;
        for (int i = 0; i < size; i++) {
            String plName = this.getPlayers().get(i).getName();
            if(playerName.equals(plName)){
                playerIsInTeam = true;
                this.getPlayers().remove(i);
                break;
            }
        }
        if(!playerIsInTeam){
            throw new IllegalArgumentException("Player "+ playerName +" is not in "+ this.getName() +" team.");
        }
    }

    public void calculateStats(){
        double stats = 0;
        double counter = 0;
        for (Player player : players) {
            stats += player.getAverageStats();
            counter++;
        }
        if(getPlayers().isEmpty()){
            this.setStats(0);
        }
        this.setStats(stats / counter);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getName(), Math.round(this.getStats()));
    }
}
