package com.assembly.task.data

/**
 * Developed by Manjunath on 28,June,2022
 */
interface PreferenceHelper {

    fun getFavorites():MutableSet<String>?
    fun addToFavorites(id:String)
    fun deleteFromFavorites(id: String)
}