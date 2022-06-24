package com.assembly.task.api

import com.assemblytask.models.PicsModel
import com.assemblytask.models.SubRedditModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Developed by Manjunath on 19,June,2022
 */

interface RedditApiServices {
    /**
     * Fetch Pics
     */
    @GET("/r/{subreddit}/.json?jsonp=")
    suspend fun getPics(@Path("subreddit") subredditType:String): PicsModel

    @GET("/subreddits/.json")
    suspend fun getSubRedditTypes(): SubRedditModel

}