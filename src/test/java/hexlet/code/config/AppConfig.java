package hexlet.code.config;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppConfig {

    @Bean
    public Faker getFaker() {
        return new Faker(new Locale("en", "US"));
    }
}
