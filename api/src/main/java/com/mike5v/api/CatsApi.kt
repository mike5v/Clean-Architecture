package com.mike5v.api

import retrofit2.http.GET

interface CatsApi {

    @GET("images/search")
    suspend fun getCatFromNetwork(): List<CatModel>
}