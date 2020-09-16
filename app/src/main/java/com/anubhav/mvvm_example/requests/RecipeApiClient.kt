package com.anubhav.mvvm_example.requests

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.anubhav.mvvm_example.model.Recipe
import com.anubhav.mvvm_example.requests.responses.RecipeSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RecipeApiClient {

    private const val TAG = "RecipeApiClient"
    var recipes: MutableLiveData<List<Recipe>> = MutableLiveData()

    fun searchRecipeApi(query: String, pageNumber: Int) {
        val recipeSearchResponse: Call<RecipeSearchResponse> =
            ServiceGenerator.apiService.searchRecipe(query, pageNumber.toString())

        recipeSearchResponse.enqueue(object : Callback<RecipeSearchResponse> {
            override fun onResponse(
                call: Call<RecipeSearchResponse>,
                response: Response<RecipeSearchResponse>
            ) {
                if (response.code() == 200) {
                    val recipesList = response.body()?.recipes
                    recipes.postValue(recipesList)
                } else {
                    recipes.postValue(null)
                    Log.e(TAG, "onResponse: ${response.errorBody()?.toString()}")
                }
            }

            override fun onFailure(call: Call<RecipeSearchResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: $t")
            }
        })
    }
}