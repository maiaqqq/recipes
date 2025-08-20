package com.example.recipes.repositories;

import com.example.recipes.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    
}
