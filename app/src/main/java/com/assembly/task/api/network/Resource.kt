package com.assembly.task.api.network

import okhttp3.ResponseBody

/**
 * Developed by Manjunath on 19,June,2022
 */

sealed class Resource<out T> {
    data class Success<out T>(val value : T) : Resource<T>()
    data class Failure  (
        val isNetworkError: Boolean,
        val errorCode : Int?,
        val errorBody : ResponseBody?
    ): Resource<Nothing>()
}