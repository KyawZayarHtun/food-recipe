package com.bezen.controller;

import com.bezen.entity.Recipes;
import com.bezen.entity.Users;
import com.bezen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model, Users users) {
        model.addAttribute("users", users);

        return "sign-up";
    }

    @PostMapping("/save-user")
    public String saveUser(Users user) {
        service.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/add-recipe")
    public String addRecipe(Model model, Recipes recipes) {
        model.addAttribute("recipes", recipes);
        return "add-recipe";
    }

    @PostMapping("/save-recipe")
    public String saveRecipe(Principal principal, Recipes recipe) {
        if (recipe.getId() == 0) {
            service.addRecipe(principal, recipe);
        } else {
            service.updateRecipe(recipe);
        }
        return "redirect:/show-all";
    }

    @GetMapping("/show-all")
    public String showAllRecipes(@RequestParam(value = "keyword", required = false) String keyword, Model model, Principal principal) {
        if (keyword == null) {
            List<Recipes> recipesList = service.showAllRecipe(principal);
            model.addAttribute("recipes", recipesList);
        } else {
            List<Recipes> byKeyword = service.getByKeyword(keyword, principal);
            model.addAttribute("recipes", byKeyword);
        }
        return "show-all";
    }

    @GetMapping("/recipe-detail")
    public String showDetail(Model model, @RequestParam("id") int id) {
        Recipes recipeById = service.getRecipeById(id);
        model.addAttribute("recipe", recipeById);
        return "detail-page";
    }

    @GetMapping("/update-recipe")
    public String updateRecipe(@RequestParam("id") int id, Model model) {
        Recipes recipeById = service.getRecipeById(id);
        model.addAttribute("recipes", recipeById);
        return "add-recipe";
    }

    @GetMapping("/delete-recipe")
    public String deleteRecipe(@RequestParam("id") int id) {
        service.deleteRecipe(id);
        return "redirect:/show-all";
    }
}
