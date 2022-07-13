package rockets.sparkathon.painless.serverless.templategenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template-generator")
public class GeneratorService {

    @GetMapping("/hello")
    public void hello(){
        System.out.println("hello");
    }


}
