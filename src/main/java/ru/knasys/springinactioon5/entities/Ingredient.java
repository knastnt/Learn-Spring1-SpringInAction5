package ru.knasys.springinactioon5.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data /*Генерирует геттеры и сеттеры к полям класса, а также hashcode, equails, toString*/
@AllArgsConstructor
public class Ingredient {
    private String id;
    private String name;
    private Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
