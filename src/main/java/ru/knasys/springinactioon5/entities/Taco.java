package ru.knasys.springinactioon5.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, message = "Имя должно быть не менее 2 и не более 20 символов", max = 20)
    private String name;

    @NotNull(message = "Выбирите хотябы один ингридиент")
    @Size(min = 1, message = "Выбирите хотябы один ингридиент")
    @ManyToMany
    private List<Ingredient> ingredients;

    private Date createAt;

    @PrePersist
    private void createdAt(){
        createAt = new Date();
    }
}
