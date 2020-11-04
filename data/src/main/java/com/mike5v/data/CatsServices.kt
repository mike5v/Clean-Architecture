package com.mike5v.data

import com.mike5v.domain.Cat

interface CatsServices {

    suspend fun getCat(): Cat
}