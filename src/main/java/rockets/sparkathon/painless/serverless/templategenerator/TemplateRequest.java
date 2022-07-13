package rockets.sparkathon.painless.serverless.templategenerator;

public class TemplateRequest {

    private String teamName;
    private String lambdaName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLambdaName() {
        return lambdaName;
    }

    public void setLambdaName(String lambdaName) {
        this.lambdaName = lambdaName;
    }
}
