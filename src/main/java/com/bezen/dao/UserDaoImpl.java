package com.bezen.dao;

import com.bezen.entity.Recipes;
import com.bezen.entity.Users;
import com.bezen.rowmapper.RecipesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(Users users) {
        String sql = "insert into users(username, password) values (?, ?)";
        String encodePass = passwordEncoder.encode(users.getPassword());
        String sql2 = "insert into authorities(username) values (?)";
        Object[] args = {users.getUsername(), encodePass};
        jdbcTemplate.update(sql, args);
        jdbcTemplate.update(sql2, users.getUsername());
    }

    @Override
    public void addRecipe(Principal principal, Recipes recipes) {
        String sql = "insert into recipe(username, title, description, ingredients, steps) values(?,?,?,?,?)";
        Object[] args = {principal.getName(), recipes.getTitle(), recipes.getDescription(), recipes.getIngredients(), recipes.getSteps()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public List<Recipes> showAllRecipe(Principal principal) {
        String sql = "select * from recipe where username = '" + principal.getName() + "'";
        return jdbcTemplate.query(sql, new RecipesRowMapper());
    }

    @Override
    public Recipes getRecipeById(int id) {
        String sql = "select * from recipe where id = ?";
        return jdbcTemplate.queryForObject(sql, new RecipesRowMapper(), id);
    }

    @Override
    public void updateRecipe(Recipes recipe) {
        String sql = "update recipe set title=?, description=?, ingredients=?, steps=? where id=?";
        Object[] args = {recipe.getTitle(), recipe.getDescription(), recipe.getIngredients(), recipe.getSteps(), recipe.getId()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void deleteRecipe(int id) {
        String sql = "delete from recipe where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Recipes> getByKeyword(String keyword, Principal principal) {
        String sql = "select * from recipe where title like ? and username=?";
        Object[] args = {"%" + keyword +"%", principal.getName()};
        return jdbcTemplate.query(sql, new RecipesRowMapper(), args);
    }
}
