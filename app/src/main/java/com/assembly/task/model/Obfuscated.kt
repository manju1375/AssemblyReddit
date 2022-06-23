package com.assemblytask.models

import com.google.gson.annotations.SerializedName


data class Obfuscated (

  @SerializedName("source"      ) var source      : Source?                = null,
  @SerializedName("resolutions" ) var resolutions : ArrayList<Resolutions>? = null

)