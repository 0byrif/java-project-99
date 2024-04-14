package hexlet.code.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Добро пожаловать")
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring";
    }
}
