package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface IngredientDao {

    @Insert
    void addIngredient(Ingredient ingredient);

}
