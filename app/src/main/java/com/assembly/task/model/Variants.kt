package com.assemblytask.models

import com.google.gson.annotations.SerializedName


data class Variants (

  @SerializedName("obfuscated" )
  var obfuscated : Obfuscated? = null,
  @SerializedName("nsfw"       ) var nsfw       : Nsfw?       = null

)