package com.assembly.task.model.subreddittypes

import com.assembly.task.modelimport.MediaEmbed
import com.assemblytask.models.AllAwardings
import com.assemblytask.models.Gildings
import com.assemblytask.models.Preview
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SubRedditChildrenData(

    @SerializedName("display_name")
    @Expose
    val displayName: String
)