package com.mike5v.domain

interface CatsRepository {

    suspend fun getCatUrlImage(): String
}