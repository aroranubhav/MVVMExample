package com.anubhav.mvvm_example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.anubhav.mvvm_example.model.Recipe
import com.anubhav.mvvm_example.repository.RecipeRepository

class MainActivityViewModel : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository

    fun getRecipes(): LiveData<List<Recipe>> {
        return recipeRepository.getRecipes()
    }

    fun searchRecipe(query: String, pageNumber: Int) {
        recipeRepository.searchRecipeApi(query, pageNumber)
    }
}