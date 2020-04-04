package ru.knasys.springinactioon5.entities;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    private Long id;
    @NotNull
    @Size(min = 2, message = "Имя должно быть не менее 2 и не более 20 символов", max = 20)
    private String name;
    @NotNull(message = "Выбирите хотябы один ингридиент")
    @Size(min = 1, message = "Выбирите хотябы один ингридиент")
    private List<String> ingredients;
}
