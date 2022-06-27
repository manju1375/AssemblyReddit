package com.assembly.task.model.subreddittypes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SubRedditChildren (
  @SerializedName("kind" ) var kind : String? = null,
  @SerializedName("data" )
  @Expose
  var data : SubRedditChildrenData?   = null
)