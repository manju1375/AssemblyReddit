package com.assemblytask.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PicsModel (

  @SerializedName("kind" )
  @Expose
  var kind : String? = null,
  @SerializedName("data" )
  @Expose
  var data : Data?   = null

)