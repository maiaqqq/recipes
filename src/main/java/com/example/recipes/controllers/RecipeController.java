package com.example.recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.recipes.entities.Recipe;

import java.util.*;

import com.services.UserService;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    UserService userService;

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe;
        if(userService.getCurrentUser() != null){
            newRecipe.setUser(userService.getCurrentUser());
        }
        return newRecipe;
    }
}
