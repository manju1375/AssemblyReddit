package com.assemblytask.models

import com.google.gson.annotations.SerializedName


data class Obfuscated (

  @SerializedName("source"      ) var source      : Source?                = Source(),
  @SerializedName("resolutions" ) var resolutions : ArrayList<Resolutions> = arrayListOf()

)