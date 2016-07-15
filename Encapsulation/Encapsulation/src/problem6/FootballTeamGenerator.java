package problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Radoslav on 15.7.2016 г..
 */
public class FootballTeamGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, FootballTeam> teamMap = new HashMap<>();
        while (true){
            String[] input = sc.readLine().split(";");
            if(input[0].equals("END")){
                break;
            }

            switch (input[0]){
                case "Team":
                    try{
                        FootballTeam footballTeam = new FootballTeam(input[1]);
                        teamMap.put(input[1], footballTeam);
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add": {
                    String teamName = input[1];
                    String playerName = input[2];
                    double endurance = Double.valueOf(input[3]);
                    double sprint = Double.valueOf(input[4]);
                    double dribble = Double.valueOf(input[5]);
                    double passing = Double.valueOf(input[6]);
                    double shooting = Double.valueOf(input[7]);

                    try {
                        if (!teamMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.\n", teamName);
                            continue;
                        }

                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teamMap.get(teamName).addPlayers(player);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case "Remove": {
                    String teamName = input[1];
                    String playerName = input[2];

                    if (!teamMap.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                        continue;
                    }
                    try{
                        teamMap.get(teamName).removePlayer(playerName);
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }

                    break;
                }
                case "Rating":
                    String teamName = input[1];
                    if (!teamMap.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                        continue;
                    }
                    teamMap.get(teamName).calculateStats();
                    System.out.println(teamMap.get(teamName).toString());
                    break;

            }
        }
    }
}
