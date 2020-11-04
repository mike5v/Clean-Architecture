package com.mike5v.domain

class CatsUseCase(private val catsRepository: CatsRepository) {

    suspend fun getCatUrlImage() = catsRepository.getCat().url
}