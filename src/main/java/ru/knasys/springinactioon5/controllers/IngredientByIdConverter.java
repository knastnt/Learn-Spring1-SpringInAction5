package ru.knasys.springinactioon5.controllers;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.core.convert.converter.Converter;
        import org.springframework.stereotype.Component;
        import ru.knasys.springinactioon5.db.IngredientRepository;
        import ru.knasys.springinactioon5.entities.Ingredient;


@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findOne(id);
    }

}