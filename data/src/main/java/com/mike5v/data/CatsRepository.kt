package com.mike5v.data

import com.mike5v.domain.CatsRepository
import javax.inject.Inject

class CatsRepository @Inject constructor(private val service: CatsServices) : CatsRepository {

    override suspend fun getCatUrlImage(): String = service.getCat().url
}