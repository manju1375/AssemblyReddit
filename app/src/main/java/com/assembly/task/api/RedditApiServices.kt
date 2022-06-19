package com.assembly.task.api

import com.assemblytask.models.PicsModel
import retrofit2.http.GET

/**
 * Developed by Manjunath on 19,June,2022
 */

interface RedditApiServices {
    /**
     * Fetch Pics
     */
    @GET("/r/pics/.json")
    suspend fun getPics(): PicsModel
}