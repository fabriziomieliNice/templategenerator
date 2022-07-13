package rockets.sparkathon.painless.serverless.templategenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/generate")
public class GeneratorController {

    @Autowired
    CommanderService commanderService;

    @PostMapping
    public String hello1(@RequestBody TemplateRequest body) throws Exception {
        String lambdaName = body.getLambdaName();
        commanderService.invokeCommandLine("curl", "-u", "'fabriziomieliNice:Davare123'", "https://api.github.com/user/repos", "-d", "'{\\\"name\\\":\\\"" + lambdaName + "\\\"}'", "-H", "\\\"Authorization: token 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\\\"");
        commanderService.invokeCommandLine("mkdir", "c://sparkathon//" + lambdaName);
        commanderService.invokeCommandLine("cp", "-rf", "src//main//resources//lambda-template//*", "C://sparkathon//" + lambdaName);

        replace(lambdaName,"%%SNSTopic%%","myTopic");
        replace( lambdaName,"%%lambdaName%%",lambdaName);
        replace( lambdaName,"%%teamName%%","rockets");
        replace( lambdaName,"%%product%%","appLink");
        replace( lambdaName,"%%bucketName%%","bucketName");
        replace( lambdaName,"%%bucketPrefix%%","bucketPrexix");
        replace( lambdaName,"%%description%%","description");
        replace( lambdaName,"%%mailRecipients%%","our mails");
        replace( lambdaName,"%%VCteam%%","myvxteam");
        replace( lambdaName,"%%virtualApplication%%","myVirtApp");

        commanderService.invokeCommandLine("cd", "c://sparkathon//" + lambdaName + ";", "git", "init");
        commanderService.invokeCommandLine("cd", "c://sparkathon//" + lambdaName + ";", "git", "add", ".");
        commanderService.invokeCommandLine("cd", "c://sparkathon//" + lambdaName + ";", "git", "commit", "-m", "'Rockets Generator'");
        commanderService.invokeCommandLine("cd", "c://sparkathon//" + lambdaName + ";", "git", "remote", "add", "origin", "https://github.com/fabriziomieliNice/" + lambdaName + ".git");
        commanderService.invokeCommandLine("cd", "c://sparkathon//" + lambdaName + ";", "git", "push", "origin", "master");
        return "https://github.com/fabriziomieliNice/" + lambdaName;

    }

    private void replace(String lambdaName, String ph, String value) throws Exception {
        commanderService.invokeCommandLine("cd", "c://sparkathon//" + lambdaName + ";", "grep", "-rl", ph, ".", "|", "xargs", "sed", "-i", "'s/" + ph + "/" + value + "/g'");

    }


}
