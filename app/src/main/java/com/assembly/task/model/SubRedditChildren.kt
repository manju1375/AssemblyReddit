package com.assemblytask.models

import com.assembly.task.model.*
import com.assembly.task.modelimport.MediaEmbed
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SubRedditChildren (
  @SerializedName("kind" ) var kind : String? = null,
  @SerializedName("data" )
  @Expose
  var data : SubRedditChildrenData?   = null
)