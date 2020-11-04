package com.mike5v.data

import com.mike5v.domain.Cat
import com.mike5v.domain.CatsRepository

class CatsRepository(private val service: CatsServices) : CatsRepository {

    override suspend fun getCat(): Cat = service.getCat()
}