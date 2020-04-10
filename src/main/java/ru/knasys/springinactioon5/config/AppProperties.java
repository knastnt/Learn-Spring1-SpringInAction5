package ru.knasys.springinactioon5.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "taco")
public class AppProperties {
    private int orderPageSize = 10;
}
