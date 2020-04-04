package ru.knasys.springinactioon5.db;

import org.springframework.stereotype.Repository;
import ru.knasys.springinactioon5.entities.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    void save(Ingredient ingredient);
}
