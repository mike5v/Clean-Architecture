package com.mike5v.api

import com.mike5v.data.Cat
import com.mike5v.data.CatsServices
import javax.inject.Inject

class RetrofitCatsApi @Inject constructor(val api: CatsApi): CatsServices {

    override suspend fun getCat(): Cat = api.getCatFromNetwork().first().map()
}