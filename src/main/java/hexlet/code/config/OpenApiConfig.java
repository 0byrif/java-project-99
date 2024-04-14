package hexlet.code.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Менеджер задач",
                description = "Task Manager", version = "1.0.0",
                contact = @Contact(
                        name = "Obyrif",
                        email = "ddelor@yande.ru",
                        url = "https://github.com/Obyrif"
                )
        )
)
public class OpenApiConfig {

}
