package ru.knasys.springinactioon5.db;

import org.springframework.data.repository.CrudRepository;
import ru.knasys.springinactioon5.entities.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
