package rockets.sparkathon.painless.serverless.templategenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/template-generator")
public class GeneratorService {

    @PostMapping
    public void hello1(@RequestBody TemplateRequest body){
        System.out.println("post");
    }

}
