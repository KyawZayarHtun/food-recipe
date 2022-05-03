package com.bezen.rowmapper;

import com.bezen.entity.Recipes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipesRowMapper implements RowMapper<Recipes> {
    @Override
    public Recipes mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipes recipes = new Recipes();
        recipes.setId(rs.getInt("id"));
        recipes.setUsername(rs.getString("username"));
        recipes.setTitle(rs.getString("title"));
        recipes.setDescription(rs.getString("description"));
        recipes.setIngredients(rs.getString("ingredients"));
        recipes.setSteps(rs.getString("steps"));
        return recipes;
    }
}
