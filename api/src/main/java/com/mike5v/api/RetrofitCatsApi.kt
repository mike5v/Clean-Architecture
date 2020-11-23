package com.mike5v.api

import com.mike5v.data.Cat
import com.mike5v.data.CatsServices

class RetrofitCatsApi: CatsServices {

    private val api = Network.createService(service = CatsApi::class.java)

    override suspend fun getCat(): Cat = api.getCatFromNetwork().first().map()
}