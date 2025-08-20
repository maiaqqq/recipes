package com.example.recipes.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe")

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPE_ID")
    private Integer id;
    
    @Column(name = "TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false, updatable = false)
    private User user;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "INGREDIENTS")
    private List<String> ingredients = new ArrayList<>();

    @Column(name = "STEPS")
    private List<String> steps = new ArrayList<>();

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public List<String> getIngredients(){
        return ingredients;
    }

    public void setIngredients(List<String> ingredients){
        this.ingredients = ingredients;
    }

    public List<String> getSteps(){
        return steps;
    }

    public void setSteps(List<String> steps){
        this.steps = steps;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}