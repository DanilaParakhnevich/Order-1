package by.bogomaz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("by.bogomaz.app.entity")
@EnableJpaRepositories("by.bogomaz.app.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
