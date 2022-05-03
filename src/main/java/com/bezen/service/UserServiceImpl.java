package com.bezen.service;

import com.bezen.dao.UserDao;
import com.bezen.entity.Recipes;
import com.bezen.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public void saveUser(Users user) {
        dao.save(user);
    }

    @Override
    public void addRecipe(Principal principal, Recipes recipes) {
        dao.addRecipe(principal, recipes);
    }

    @Override
    public List<Recipes> showAllRecipe(Principal principal) {
        List<Recipes> showRecipes = dao.showAllRecipe(principal);
        return showRecipes;
    }

    @Override
    public Recipes getRecipeById(int id) {
        return dao.getRecipeById(id);
    }

    @Override
    public void updateRecipe(Recipes recipe) {
        dao.updateRecipe(recipe);
    }

    @Override
    public void deleteRecipe(int id) {
        dao.deleteRecipe(id);
    }

    @Override
    public List<Recipes> getByKeyword(String keyword, Principal principal) {
        return dao.getByKeyword(keyword, principal);
    }
}
