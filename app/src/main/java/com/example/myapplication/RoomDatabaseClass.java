package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Ingredient.class}, version = 2)
public abstract class RoomDatabaseClass extends RoomDatabase {

    public abstract IngredientDao ingredientDao();

}
