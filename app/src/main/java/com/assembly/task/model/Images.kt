package com.assemblytask.models

import com.google.gson.annotations.SerializedName


data class Images (

  @SerializedName("source"      ) var source      : Source?                = null,
  @SerializedName("resolutions" ) var resolutions : ArrayList<Resolutions>? = null,
  @SerializedName("variants"    ) var variants    : Variants?              = null,
  @SerializedName("id"          ) var id          : String?                = null

)