package rockets.sparkathon.painless.serverless.templategenerator;

public class TemplateRequest {

    private String team_name;
    private String lambda_name;

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getLambda_name() {
        return lambda_name;
    }

    public void setLambda_name(String lambda_name) {
        this.lambda_name = lambda_name;
    }
}
