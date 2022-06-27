package com.assembly.task.data

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


/**
 * Created by Manjunath on 28/06/22.
 */
class AppPreferencesHelper @Inject constructor(
    @ApplicationContext context: Context,
) :
    PreferenceHelper {
    private val mPrefs: SharedPreferences
    private var favoriteSet:Set<String>

    companion object {
        private const val PREF_KEY_FAVORITES = "PREF_KEY_FAVORITES"
    }

    init {
        mPrefs = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
        favoriteSet = getFavorites()?: mutableSetOf()
        mPrefs.edit().putStringSet(PREF_KEY_FAVORITES,favoriteSet).apply()
    }

    override fun getFavorites(): MutableSet<String>? {
        return mPrefs.getStringSet(PREF_KEY_FAVORITES, null)
    }

    override fun addToFavorites(id: String) {
        getFavorites()?.add(id)
        mPrefs.edit().putStringSet(PREF_KEY_FAVORITES,getFavorites()).apply()
    }

    override fun deleteFromFavorites(id: String) {
        getFavorites()?.remove(id)
        mPrefs.edit().putStringSet(PREF_KEY_FAVORITES,getFavorites()).apply()
    }
}