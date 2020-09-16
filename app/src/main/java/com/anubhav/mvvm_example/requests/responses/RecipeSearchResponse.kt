package com.anubhav.mvvm_example.requests.responses

import com.anubhav.mvvm_example.model.Recipe
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("count") @Expose val count: Int,
    @SerializedName("recipes") @Expose val recipes: List<Recipe>
)