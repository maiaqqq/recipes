package com.example.recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.recipes.entities.Recipe;
import java.time.LocalDateTime;
import java.util.*;
import com.example.recipes.repositories.RecipeRepository;
import com.example.recipes.services.UserService;
import com.example.recipes.services.RecipeService;
import com.example.recipes.exceptions.*;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

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

    @PutMapping("{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable String recipeId, @RequestBody Recipe recipe) {
        if(recipeId == null || recipeService.findById(recipeId) == null){
           throw new BadRequestException("Recipe id is invalid");
        }
        Recipe updatedRecipe = findRecipe(recipeId);
        updatedRecipe.setCreatedAt(LocalDateTime.now());
        updatedRecipe.setDescription(recipe.getDescription());
        updatedRecipe.setIngredients(recipe.getIngredients());
        updatedRecipe.setSteps(recipe.getSteps());
        updatedRecipe.setTitle(recipe.getTitle());

        return ResponseEntity.ok("Recipe created successfully");
    }
}
