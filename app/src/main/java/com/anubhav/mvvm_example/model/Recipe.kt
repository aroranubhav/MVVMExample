package com.anubhav.mvvm_example.model

data class Recipe(
    val title: String?, val publisher: String?, val ingredients: Array<String>,
    val recipe_id: String?, val image_url: String?, val social_rank: Float
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recipe

        if (title != other.title) return false
        if (publisher != other.publisher) return false
        if (!ingredients.contentEquals(other.ingredients)) return false
        if (recipe_id != other.recipe_id) return false
        if (image_url != other.image_url) return false
        if (social_rank != other.social_rank) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title?.hashCode() ?: 0
        result = 31 * result + (publisher?.hashCode() ?: 0)
        result = 31 * result + ingredients.contentHashCode()
        result = 31 * result + (recipe_id?.hashCode() ?: 0)
        result = 31 * result + (image_url?.hashCode() ?: 0)
        result = 31 * result + social_rank.hashCode()
        return result
    }
}