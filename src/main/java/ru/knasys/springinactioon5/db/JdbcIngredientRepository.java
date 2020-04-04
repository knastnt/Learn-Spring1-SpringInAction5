package ru.knasys.springinactioon5.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.knasys.springinactioon5.entities.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        /*language=SQL*/
        return jdbcTemplate.query("select id, name, type from Ingredients", (resultSet, i) -> this.mapRow2Ingredient(resultSet, i));
    }

    @Override
    public Ingredient findOne(String id) {
        /*language=SQL*/
        return jdbcTemplate.queryForObject("select id, name, type from Ingredients where id=?", this::mapRow2Ingredient, id);
    }

    @Override
    public void save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredients (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().name()
                );
    }

    private Ingredient mapRow2Ingredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type").toUpperCase())
        );
    }
}
