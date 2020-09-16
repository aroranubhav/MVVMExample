package com.anubhav.mvvm_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anubhav.mvvm_example.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        observeData()

        btn_search.setOnClickListener {
            searchRecipes()
        }
    }

    //observing for data changes.
    private fun observeData() {
        viewModel.getRecipes().observe(this, Observer { recipes ->
            recipes?.let {
                //logging the fetched data for checking purpose
                for (recipe in recipes) {
                    Log.d(TAG, "observeData: $recipe")
                }
            }
        })
    }


    //calling with random query data from the api, for chicken as the query and a default page number
    private fun searchRecipes() {
        viewModel.searchRecipe("sfjbjsdfsgfl", 0)
    }
}