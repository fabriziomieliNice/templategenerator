package rockets.sparkathon.painless.serverless.templategenerator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/generate")
public class GeneratorService {

    @PostMapping
    public ResponseEntity<TemplateRequest> hello1(@RequestBody TemplateRequest body){
        System.out.println("post");
        return ResponseEntity.ok(body);
    }

}
