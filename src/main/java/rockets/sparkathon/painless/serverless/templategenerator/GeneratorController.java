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
    public String hello1(@RequestBody TemplateRequest body) throws Exception{
        String lambdaName=body.getLambdaName();
        commanderService.invokeCommandLine("curl","-u","'fabriziomieliNice:Davare123'","https://api.github.com/user/repos","-d","'{\\\"name\\\":\\\""+lambdaName+"\\\"}'","-H","\\\"Authorization: token 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\\\"");
        commanderService.invokeCommandLine("mkdir","c://sparkathon//"+lambdaName);
        commanderService.invokeCommandLine("touch","c://sparkathon//"+lambdaName+"//a.txt");
        commanderService.invokeCommandLine("cd","c://sparkathon//"+lambdaName+";", "touch","b.txt");
        commanderService.invokeCommandLine("cd","c://sparkathon//"+lambdaName+";", "git","init");
        commanderService.invokeCommandLine("cd","c://sparkathon//"+lambdaName+";", "git","add","a.txt","b.txt");
        commanderService.invokeCommandLine("cd","c://sparkathon//"+lambdaName+";", "git","commit","-m","'Rockets Generator'");
        commanderService.invokeCommandLine("cd","c://sparkathon//"+lambdaName+";", "git","remote", "add", "origin", "https://github.com/fabriziomieliNice/"+lambdaName+".git");
        commanderService.invokeCommandLine("cd","c://sparkathon//"+lambdaName+";", "git","push", "origin", "master");
        return "https://github.com/fabriziomieliNice/"+lambdaName;

    }


}
