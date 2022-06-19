package com.assemblytask.models

import com.google.gson.annotations.SerializedName


data class PicsModel (

  @SerializedName("kind" ) var kind : String? = null,
  @SerializedName("data" ) var data : Data?   = Data()

)