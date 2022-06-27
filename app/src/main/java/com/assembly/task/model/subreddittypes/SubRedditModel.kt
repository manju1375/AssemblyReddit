package com.assembly.task.model.subreddittypes

import com.assembly.task.model.subreddittypes.SubRedditData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SubRedditModel (

  @SerializedName("kind" )
  @Expose
  var kind : String? = null,
  @SerializedName("data" )
  @Expose
  var data : SubRedditData?   = null

)