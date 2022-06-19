package com.assembly.task.repository

import com.assembly.task.api.RedditApiServices
import javax.inject.Inject

/**
 * Developed by Manjunath on 19,June,2022
 */

class PicsRepository @Inject constructor(private val redditApiServices: RedditApiServices):
    BaseRepository() {
        suspend fun getPics() = safeApiCall {
            redditApiServices.getPics()
        }
}