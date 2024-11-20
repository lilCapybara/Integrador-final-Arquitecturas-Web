package Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prueba")
public class NewController {

    @GetMapping("")
    public String getMapping(){
        return "Mapping";
    }
}
