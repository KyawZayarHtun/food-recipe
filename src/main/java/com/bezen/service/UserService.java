package com.bezen.service;

import com.bezen.entity.Recipes;
import com.bezen.entity.Users;

import java.security.Principal;
import java.util.List;

public interface UserService {
    void saveUser(Users user);
    void addRecipe(Principal principal, Recipes recipes);
    List<Recipes> showAllRecipe(Principal principal);
    Recipes getRecipeById(int id);
    void updateRecipe(Recipes recipe);
    void deleteRecipe(int id);
    List<Recipes> getByKeyword(String keyword, Principal principal);
}
