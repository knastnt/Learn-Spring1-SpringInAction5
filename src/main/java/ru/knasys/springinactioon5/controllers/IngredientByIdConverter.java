package ru.knasys.springinactioon5.controllers;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.core.convert.converter.Converter;
        import org.springframework.stereotype.Component;
        import ru.knasys.springinactioon5.db.IngredientRepository;
        import ru.knasys.springinactioon5.entities.Ingredient;

/*
позволяет решить исключение
Failed to convert property value of type java.lang.String to required type java.util.List for property ingredients;
nested exception is java.lang.IllegalStateException: Cannot convert value of type java.lang.String to required type
ru.knasys.springinactioon5.entities.Ingredient for property ingredients[0]: no matching editors or conversion strategy found
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
//        return ingredientRepo.findOne(id);
        return ingredientRepo.findById(id).get();
    }

}