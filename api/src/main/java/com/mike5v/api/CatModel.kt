package com.mike5v.api

import com.mike5v.data.Cat
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatModel(
    val id: String,
    val url: String
) {
    fun map() = Cat(id, url)
}

