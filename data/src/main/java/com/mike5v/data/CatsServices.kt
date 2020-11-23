package com.mike5v.data

interface CatsServices {

    suspend fun getCat(): Cat
}