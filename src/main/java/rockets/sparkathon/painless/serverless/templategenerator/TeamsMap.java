package rockets.sparkathon.painless.serverless.templategenerator;

import java.util.Hashtable;

public class TeamsMap {

    private Hashtable<String, TeamData> teams = new Hashtable<>();

    public TeamData getTeamData(String teamName) {
        return teams.get(teamName);
    }
}
