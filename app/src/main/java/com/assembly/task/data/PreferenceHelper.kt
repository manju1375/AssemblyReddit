package com.assembly.task.data

interface PreferenceHelper {

    fun getFavorites():MutableSet<String>?
    fun addToFavorites(id:String)
    fun deleteFromFavorites(id: String)
}