package com.mike5v.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatModel(
    val id: String,
    val url: String
)

