package ru.knasys.springinactioon5.entities;

import lombok.*;

import javax.persistence.*;

@Data /*Генерирует геттеры и сеттеры к полям класса, а также hashcode, equails, toString*/
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
