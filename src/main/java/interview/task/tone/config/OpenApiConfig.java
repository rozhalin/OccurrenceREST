package interview.task.tone.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI tOneApplicationProject() {
        return new OpenAPI()
                .info(new Info()
                        .description("Т1 Консалтинг")
                        .title("Тестовое задание")
                        .version("v0.1")
                        .contact(new Contact().name("Roman R."))
                );
    }
}
