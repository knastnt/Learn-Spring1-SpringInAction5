package ru.knasys.springinactioon5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.knasys.springinactioon5.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class})
public class Springinactioon5Application {

    public static void main(String[] args) {
        SpringApplication.run(Springinactioon5Application.class, args);
    }

}
