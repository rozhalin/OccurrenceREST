package interview.task.tone;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TOneApplication.class, args);
        log.info("swagger is running on http://localhost:8080/swagger-ui/index.html");
    }
}
