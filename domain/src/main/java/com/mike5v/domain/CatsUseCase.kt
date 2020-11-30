package com.mike5v.domain

class CatsUseCase(private val catsRepository: CatsRepository): Executor<String> {

    override suspend fun execute() = catsRepository.getCatUrlImage()
}