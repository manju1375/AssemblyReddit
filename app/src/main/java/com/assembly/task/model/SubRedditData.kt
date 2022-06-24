package com.assemblytask.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SubRedditData (

  @SerializedName("after"      ) var after     : String?             = null,
  @SerializedName("dist"       ) var dist      : Int?                = null,
  @SerializedName("modhash"    ) var modhash   : String?             = null,
  @SerializedName("geo_filter" ) var geoFilter : String?             = null,
  @SerializedName("children"   )
  @Expose
  var children  : ArrayList<SubRedditChildren>? = null,
  @SerializedName("before"     ) var before    : String?             = null

)