package com.anubhav.mvvm_example.requests

import com.anubhav.mvvm_example.requests.responses.RecipeSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //search recipe
    @GET("/api/search")
    fun searchRecipe(
        @Query("q") q: String,
        @Query("page") page: String
    ): Call<RecipeSearchResponse>

}