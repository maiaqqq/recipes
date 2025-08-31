package com.example.recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.recipes.entities.Recipe;
import java.time.LocalDateTime;
import java.util.*;
import com.example.recipes.repositories.RecipeRepository;
import com.example.recipes.services.UserService;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    UserService userService;

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = new Recipe();
        if(userService.getCurrentUser() != null){
            newRecipe.setUser(userService.getCurrentUser());
        }
        else{
            newRecipe.setUser(null);
        }

        newRecipe.setCreatedAt(LocalDateTime.now());
        newRecipe.setDescription(recipe.getDescription());
        newRecipe.setIngredients(recipe.getIngredients());
        newRecipe.setSteps(recipe.getSteps());
        newRecipe.setTitle(recipe.getTitle());

        return newRecipe;
    }


}
