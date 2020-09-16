package com.anubhav.mvvm_example.repository

import androidx.lifecycle.LiveData
import com.anubhav.mvvm_example.model.Recipe
import com.anubhav.mvvm_example.requests.RecipeApiClient

object RecipeRepository {

    private val recipeApiClient: RecipeApiClient = RecipeApiClient

    fun getRecipes(): LiveData<List<Recipe>> {
        return recipeApiClient.recipes
    }

    fun searchRecipeApi(query: String, pageNumber: Int) {
        if (pageNumber == 0) {
            recipeApiClient.searchRecipeApi(query, 1)
        } else {
            recipeApiClient.searchRecipeApi(query, pageNumber)
        }
    }
}