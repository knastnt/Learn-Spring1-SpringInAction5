package ru.knasys.springinactioon5.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Data
@Component
@ConfigurationProperties(prefix = "taco")
@Validated  //Обязательно для валидации
public class AppProperties {
    @Min(1) //Правило валидации
    private int orderPageSize = 10;
}
